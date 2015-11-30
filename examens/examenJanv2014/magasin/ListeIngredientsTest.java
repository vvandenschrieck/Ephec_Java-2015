package cookies.magasin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListeIngredientsTest {
	Ingredient farine;
	Ingredient sucre;
	@Before
	public void setUp() throws Exception {
		//Ingrédients de base : 
		farine = new Ingredient("Farine", 10, 2); 
		
		sucre = new Ingredient("Sucre", 10, 1); 
		
	}

	@Test
	public void testAjouter() {
		ListeIngredients liste =  new ListeIngredients();
		liste.ajouter(farine, 1);
		assertTrue(liste.contient(farine, 1));
		liste.ajouter(farine, 1);
		assertTrue(liste.contient(farine, 2));
	}

	@Test
	public void testRetirer() {
		ListeIngredients liste =  new ListeIngredients();
		liste.ajouter(farine, 2);
		assertTrue(liste.contient(farine, 2));
		try {
			liste.retirer(farine, 1);
			assertTrue(liste.contient(farine, 1));
			liste.retirer(farine, 1);
			assertTrue(liste.contient(farine, 0));
		} catch (StockInsuffisantException e) {
			fail("Exception Stock Insuffisant lancée dans testRetirer()");
		}
		try {
			liste.retirer(sucre, 1);
		} catch (StockInsuffisantException e) {
			assertTrue(true);
			return;
		}
		fail("Erreur : Exception StockInsuffisant non lancée");
	}

	@Test
	public void testContient() {
		ListeIngredients liste =  new ListeIngredients();
		liste.ajouter(farine, 2);
		assertTrue(liste.contient(farine, 1));
		assertTrue(liste.contient(farine, 2));
		assertFalse(liste.contient(farine, 3));
		assertFalse(liste.contient(sucre, 1));
	}

	@Test
	public void testValeurIngredients() {
		ListeIngredients liste =  new ListeIngredients();
		liste.ajouter(farine, 2); //La farine est à 0,02 pour 10 grammes => 0,04
		liste.ajouter(sucre, 2); //Le sucre est à 0,01 pour 10 grammes => 0,02
		assertEquals(0.06, liste.valeurIngredients(), 0.0);
	}

	@Test
	public void testQuantite() {
		ListeIngredients liste =  new ListeIngredients();
		liste.ajouter(farine, 2);
		assertEquals(2, liste.quantite(farine));
		assertEquals(0, liste.quantite(sucre));
	}

}
