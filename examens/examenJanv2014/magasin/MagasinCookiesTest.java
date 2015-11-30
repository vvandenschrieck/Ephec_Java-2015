package cookies.magasin;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MagasinCookiesTest {
	MagasinCookies monMagasin;
	RecetteCookie cookieChoco;
	RecetteCookie cookieVanille;
	RecetteCookie cookieCacao;
	@Before
	public void setUp() throws Exception {
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
		cookieChoco = new RecetteCookie("Cookie aux pépites de chocolat");
		for (Map.Entry<Ingredient, Integer> entry : ingredientsDeBase.entrySet()) {
			cookieChoco.addIngredient(entry.getKey(), entry.getValue());
		}
		cookieChoco.addIngredient(chocolat, 2);

		// Creation recette 2 :
		cookieVanille = new RecetteCookie("Cookie Vanille");
		for (Map.Entry<Ingredient, Integer> entry : ingredientsDeBase.entrySet()) {
			cookieVanille.addIngredient(entry.getKey(), entry.getValue());
		}
		cookieVanille.addIngredient(vanille, 1);

		// Création recette 3 :
		cookieCacao = new RecetteCookie("Cookie au cacao");
		for (Map.Entry<Ingredient, Integer> entry : ingredientsDeBase.entrySet()) {
			cookieCacao.addIngredient(entry.getKey(), entry.getValue());
		}
		cookieCacao.addIngredient(cacao, 1);

		
		//Création d'un magasin avec 10 euros d'investissement
		monMagasin = new MagasinCookies("CookieFactory", 10);
		monMagasin.ajouterRecette(cookieCacao);
		monMagasin.ajouterRecette(cookieVanille);
		monMagasin.ajouterRecette(cookieChoco);
	}

	@Test(expected = SoldeInsuffisantException.class)  
	public void testSoldeInsuffisant() throws SoldeInsuffisantException, RecetteInconnueException{
		try {
			Cookie [] c = monMagasin.fabriquerCookies("Cookie au cacao", 1);
		} catch (StockInsuffisantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	
	@Test
	public void testFabriquerCookies() throws RecetteInconnueException {
		
		
		// Cahier de recettes
		
		try {
			monMagasin.ajouterInvestissement(40);
			Cookie [] c = monMagasin.fabriquerCookies("Cookie au cacao", 1);
			assertEquals(monMagasin.getBilan(), 50 - cookieCacao.cout() + c[0].prix(), 0.0);
		} catch (SoldeInsuffisantException e) {
			System.out.println("Erreur : Solde insuffisant. Fin de la transaction");
			fail();
		}
		catch(StockInsuffisantException e){	
		}
	}

}
