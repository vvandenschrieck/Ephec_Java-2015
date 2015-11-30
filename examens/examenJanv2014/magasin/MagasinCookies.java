package cookies.magasin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Map.Entry;

public class MagasinCookies extends Observable{
	private String nom;
	private Map<String, RecetteCookie> recettesCookies; 
	private Compte compte;
	private ListeIngredients stock;
	private ArrayList<String> ventes;
	public MagasinCookies(){
		
	}
	public MagasinCookies(String nom, int investissement){
		this.nom = nom;
		this.stock = new ListeIngredients();
		this.compte = Compte.getInstance(investissement);
		this.ventes = new ArrayList<String>();
		recettesCookies = new HashMap<String, RecetteCookie>();
		ajouterRecettesParDefaut();
	}
	public MagasinCookies(String nom,int investissement, Map<String, RecetteCookie> recettes ){
		this.nom = nom;
		this.stock = new ListeIngredients();
		this.compte = Compte.getInstance(investissement);
		this.ventes = new ArrayList<String>();
		this.recettesCookies = recettes;
	}
	/**
	 * Ajoute une recette de cookie au magasin
	 * @param r : Une recette correctement initialisée avec
	 * les ingrédients nécessaires.
	 */
	public void ajouterRecette(RecetteCookie r){
		recettesCookies.put(r.getDescriptif(), r);
		setChanged();
		notifyObservers();
	}

	public Map<String, RecetteCookie> getRecettes() {
		return recettesCookies;
	}
	/**
	 * Fabrique numCookies selon la recette donné s'il y a assez d'ingrédients en stock
	 * ou s'il est possible de compléter le stock. Le stock est modifié en fonction des ingrédients prélevés.  
	 * Le solde du compte est modifié en fonction des ingrédients qu'il a fallu acheté et du paiement des cookies 
	 * fabriqués.
	 * @param nomRecette : le nom de la recette du cookie demandé
	 * @param numCookies : Le nombre de cookies demandé (>0)
	 * @return Les cookies demandés, sous forme de tableau d'objets Cookie.
	 * @throws SoldeInsuffisantException 
	 * @throws StockInsuffisantException
	 * @throws RecetteInconnueException 
	 */
	public Cookie[] fabriquerCookies(String nomRecette, int numCookies) throws SoldeInsuffisantException, StockInsuffisantException, RecetteInconnueException {
		Cookie [] newCookies = new Cookie[numCookies];
		//1. Récupérer la recette
		RecetteCookie recette = recettesCookies.get(nomRecette);	
		if(recette==null)
			throw new RecetteInconnueException();
		//2. Prendre les ingrédients en effectuant les achats nécessaires
		préleverDansStock(recette, numCookies);
		//3. Fabriquer et vendre les cookies
		for(int i = 0; i<numCookies; i++){
			newCookies[i] = new Cookie(recette);
			vendre(newCookies[i]);
		}
		setChanged();
		notifyObservers();
		return newCookies;
	}
	/**
	 * Renvoie l'état du stock
	 * @return la liste des ingrédients contenus dans le stock
	 */
	public ListeIngredients getStock(){
		return stock;
	}
	/**
	 * Calcule la valeur du stock courant
	 * @return la somme du cout des ingrédients en stock
	 */
	public double valeurStock(){
		return stock.valeurIngredients();
	}
	/**
	 * Renvoie le solde du compte du magasin
	 * @return le solde
	 */
	public double getSolde(){
		return compte.solde();
	}
	/**
	 * Calcule le bilan financier du magasin, 
	 * à savoir le solde du compte et la valeur du stock
	 * @return le bilan calculé
	 */
	public double getBilan(){
		return getSolde() + valeurStock();
	}
	public ArrayList<String> getVentes(){
		return ventes;
	}
	/**
	 * Augmente le solde du compte du magasin
	 * @param montant
	 */
	public void ajouterInvestissement(int montant){
		compte.depot(montant);
		setChanged();
		notifyObservers();
	}
	/**
	 * Le prix du cookie est encaissé sur le solde du compte
	 * @param c
	 */
	private void vendre(Cookie c){
		compte.depot(c.prix());
		//Récupérer la date de la vente : 
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat format = new SimpleDateFormat("d/M/yy hh:mm");
		ventes.add(format.format(now) + " " + c );
		
	}
	/**
	 * @param recette : La recette spécifiant les ingrédients à prélever dans le stock pour un cookie
	 * @param numCookies : Le nombre de cookies à produire
	 * @result S'il y a suffisamment de fonds pour compléter le stock au besoin, le stock 
	 * est diminué de la quantité d'ingrédients indiqués dans la recette
	 * @throws SoldeInsuffisantException :  S'il n'y a pas suffisamment de fonds pour compléter
	 * le stock, le stock est inchangé et l'exception est lancée. 
	 * @throsw StockInsuffisantException : Cette exception n'est normalement jamais lancée puisque l'état du stock 
	 * est vérifié avant le prélèvement.  
	 */
	private void préleverDansStock(RecetteCookie recette, int numCookies)throws  SoldeInsuffisantException {
		//Si le stock est incomplet, on achète les ingrédients manquants
		completerStock(recette, numCookies);
		//Le stock est suffisant, donc on prélève ce dont on a besoin
		for(Entry<Ingredient, Integer> entry : recette.getIngredients()){
			try{
				stock.retirer(entry.getKey(), entry.getValue()*numCookies);
			}
			catch (StockInsuffisantException e){
				System.err.println("Erreur : Stock insuffisant malgré vérification préalable");
			}
		}	
	}

	/**
	 * Renvoie les achats à effectuer pour pouvoir effectuer la recette indiquée 
	 * @param recette est non null
	 * @param numCookies >0
	 * @return la liste des ingrédients en rupture de stock, avec le nombre de kilos à acheter pour chacun.  
	 */
	private ListeIngredients ingredientsAAcheter(RecetteCookie recette, int numCookies){
		ListeIngredients ingredientsManquants = new ListeIngredients();
		for(Map.Entry<Ingredient, Integer> entry : recette.getIngredients()){
			Ingredient ingredient = entry.getKey();
			int unitesNecessaires = entry.getValue() * numCookies;
			int unitesManquantes = unitesNecessaires - stock.quantite(ingredient);
			
			if(unitesManquantes > 0){
				//Calculer la quantite par kilo a acheter
				int aAcheter = (int) (ingredient.getNbUniteParKilo() * Math.ceil(unitesManquantes / ingredient.getNbUniteParKilo()));
				ingredientsManquants.ajouter(ingredient, aAcheter);
			}
		}
		return ingredientsManquants;
	}
	/**
	 * Achète la quantité d'ingrédients indiquée dans la liste d'ingrédients manquants si le solde le permet.
	 * @param ingredientsManquants : La liste des ingrédients à compléter et la quantité demandée pour chacun
	 * @post Si le solde est suffisant pour permettre de renflouer les stocks etant donné que les achats se font
	 * au kilo, après exécution de la méthode, le stock contient au minimum la quantité demandée pour chaque ingrédient
	 * @throws SoldeInsuffisantException si le solde est insuffisant pour effectuer les achats. Le stock est alors
	 * inchangé.
	 */
	private void completerStock(RecetteCookie recette, int numCookies) throws SoldeInsuffisantException{
		ListeIngredients ingredientsAAcheter = ingredientsAAcheter(recette, numCookies);
		if(ingredientsAAcheter.valeurIngredients()>compte.solde())
			throw new SoldeInsuffisantException();
		
		for(Entry<Ingredient, Integer> entry : ingredientsAAcheter){
			acheterIngredientAuKilo(entry.getKey(), entry.getValue());
		}
	}
	
	/**
	 * 
	 * @param i
	 * @param numKilos
	 * @throws SoldeInsuffisantException
	 */
	private void acheterIngredientAuKilo(Ingredient i, int quantite) throws SoldeInsuffisantException{
		compte.retrait(i.getPrixUnitaire()*quantite);
		stock.ajouter(i, quantite);
	}
	private void ajouterRecettesParDefaut(){
		// Ingrédients de base :
		Ingredient farine = new Ingredient("Farine", 10, 2);
		Ingredient beurre = new Ingredient("Beurre", 10, 3);
		Ingredient sucre = new Ingredient("Sucre", 10, 1);
		Ingredient oeufs = new Ingredient("Oeufs", 10, 5);

		// Création de la base commune des recettes
		Map<Ingredient, Integer> ingredientsDeBase = new HashMap<Ingredient, Integer>();
		ingredientsDeBase.put(farine, 1);
		ingredientsDeBase.put(sucre, 1);
		ingredientsDeBase.put(oeufs, 2);
		ingredientsDeBase.put(beurre, 1);
		// Ingrédients spéciaux :
		Ingredient cacao = new Ingredient("Cacao", 2, 15);
		Ingredient vanille = new Ingredient("Vanille", 1, 50);
		Ingredient chocolat = new Ingredient("Chocolat en pépites", 5, 20);

		// Creation recette 1 :
		RecetteCookie cookieChoco = new RecetteCookie("Cookie aux pépites de chocolat");
		for (Map.Entry<Ingredient, Integer> entry : ingredientsDeBase.entrySet()) {
			cookieChoco.addIngredient(entry.getKey(), entry.getValue());
		}
		cookieChoco.addIngredient(chocolat, 2);

		// Creation recette 2 :
		RecetteCookie cookieVanille = new RecetteCookie("Cookie Vanille");
		for (Map.Entry<Ingredient, Integer> entry : ingredientsDeBase.entrySet()) {
			cookieVanille.addIngredient(entry.getKey(), entry.getValue());
		}
		cookieVanille.addIngredient(vanille, 1);

		// Création recette 3 :
		RecetteCookie cookieCacao = new RecetteCookie("Cookie au cacao");
		for (Map.Entry<Ingredient, Integer> entry : ingredientsDeBase.entrySet()) {
			cookieCacao.addIngredient(entry.getKey(), entry.getValue());
		}
		cookieCacao.addIngredient(cacao, 1);
		ajouterRecette(cookieCacao);
		ajouterRecette(cookieVanille);
		ajouterRecette(cookieChoco);
	}
	public String getNom() {
		return nom;
	}
	
}
