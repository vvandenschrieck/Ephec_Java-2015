package cookies.magasin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IngredientTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPrixUnitaire() {
		Ingredient i = new Ingredient("farine", 10, 2);
		assertEquals(0.02, i.getPrixUnitaire(),0.0);
	}

}
