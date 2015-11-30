package cookies.magasin;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CookieTest {
	RecetteCookie maRecette;
	
	@Before
	public void setUp() throws Exception {
		//Ingrédients de base : 
		Ingredient farine = new Ingredient("Farine",10, 2);
		Ingredient sucre = new Ingredient("Sucre", 10, 1);		
		maRecette = new RecetteCookie("Test");
		//Création de la base commune des recettes
		maRecette.addIngredient(farine, 1);
		maRecette.addIngredient(sucre, 2);
		
		
	}

	@Test
	public void testPrix() {
		Cookie monCookie = new Cookie(maRecette);
		assertEquals((0.04*1.25) , monCookie.prix(), 0.0);
	}

}
