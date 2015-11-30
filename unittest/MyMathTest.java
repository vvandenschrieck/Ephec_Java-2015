package unittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyMathTest {

	@Test
	public void test() {
		try {
			assertEquals(MyMath.fact(0),1);
			assertEquals(MyMath.fact(1),1);
			assertEquals(MyMath.fact(4),24);
		} catch (NonPositiveException e) {
			// TODO Auto-generated catch block
			fail("Exception lancee avec parametres positifs");
		}
	}
	@Test(expected=NonPositiveException.class)
	public void testFactNegativeArg() throws NonPositiveException{
		MyMath.fact(-1);
		
	}

}
