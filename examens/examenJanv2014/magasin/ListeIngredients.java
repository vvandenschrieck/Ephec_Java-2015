package cookies.magasin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ListeIngredients implements Iterable<Entry<Ingredient, Integer>> {
	Map <Ingredient, Integer> liste;

	public ListeIngredients(Map<Ingredient, Integer> liste) {
		super();
		this.liste = liste;
	}
	public ListeIngredients(){
		liste = new HashMap<Ingredient, Integer>();
	}
	/**
	 * Modifie la liste d'ingrédients en ajoutant la quantité indiquée à l'ingrédient i. 
	 * Si i n'était pas encore dans la liste, il y est ajouté
	 * @param i Un objet Ingrédient non nul
	 * @param quantite le nombre de doses de l'ingrédient à ajouter (> 0)
	 */
	public void ajouter(Ingredient i, int quantite){
		if(liste.containsKey(i)){
			liste.put(i, liste.get(i)+quantite);
		}
		else{
			liste.put(i, quantite);
		}
	}
	/**
	 * 
	 * A Compléter
	 */
	public void retirer(Ingredient i, int quantite) throws StockInsuffisantException{
		if(!contient(i,quantite)){
			throw new StockInsuffisantException();
		}
		liste.put(i, liste.get(i)-quantite);
	}
	
	
	/**
	 * Cette méthode vérifie si le stock contient au minimum le nombre de doses
	 * indiquée en paramètre pour l'ingrédient i.
	 * @param i : un ingrédient
	 * @param quantite : le nombre de doses d'ingrédient demandé.  
	 * @return vrai si l'ingrédient est présent en quantité suffisante, faux sinon.  
	 */
	public boolean contient(Ingredient i, int quantite){
		if(!liste.containsKey(i) || liste.get(i) < quantite){
			return false;
		}
		return true;
	}
	/**
	 * Calcule la valeur des ingrédients contenus dans la liste.
	 * @return La valeur des ingrédients en euros
	 */
	public double valeurIngredients(){
		double c = 0;	
for(Map.Entry<Ingredient, Integer> e : liste.entrySet()){
		Ingredient MaVariable = e.getKey();
		double o;int X = e.getValue();	//X = quantite
		o = MaVariable.getPrixUnitaire(); //o = prix
		if(X > 0){ c = c+ (X*o);
				}}return c;
	}
	/**
	 * Renvoie un itérateur permettant de parcourir la liste d'ingrédients
	 */
	public Iterator<Entry<Ingredient, Integer>> iterator(){
		return liste.entrySet().iterator();
	}
	/**
	 * Renvoie le nombre de doses en stock pour l'ingrédient donné
	 * @param ingredient 
	 * @return le nombre de doses en stock de ingredient
	 */
	public int quantite(Ingredient ingredient) {
		if (!liste.containsKey(ingredient))
			return 0;
		return liste.get(ingredient);
	}
	public String toString(){
		String result = "";
		for(Entry<Ingredient, Integer> entry : liste.entrySet()){
			result += (entry.getKey() + " - " +  entry.getValue() + " unités\n");
		}
		return result;
	}
}
