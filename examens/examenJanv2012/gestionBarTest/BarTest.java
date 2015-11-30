package gestionBarTest;
import static org.junit.Assert.*;
import gestionBar.Beer;
import gestionBar.Bar;
import gestionBar.BeerNotFoundException;
import gestionBar.InsufficientStockException;

import org.junit.Before;
import org.junit.Test;


public class BarTest {
	Bar myBar;
	@Before
	public void setUp() throws Exception {
		myBar = new Bar();
		myBar.addBeer("Chimay", 10, 2);
	}
	
	@Test(expected=InsufficientStockException.class)
	public void testEmptyStock() throws BeerNotFoundException, InsufficientStockException{
		myBar.serve("Chimay");
	}
	@Test(expected=BeerNotFoundException.class)
	public void testBeerNotFound() throws BeerNotFoundException, InsufficientStockException{
		myBar.serve("Westvleteren");
	}
	@Test(expected=InsufficientStockException.class)
	public void serveUntilEmpty() throws BeerNotFoundException, InsufficientStockException {
		//Add stock
		myBar.addStock("Chimay", 3);
		for(int i=0; i<4; i++)
			myBar.serve("Chimay");
	}
	@Test
	public void testRevenue() throws BeerNotFoundException, InsufficientStockException{
		myBar.addStock("Chimay", 3); 
		for(int i=0; i<3; i++)
			myBar.serve("Chimay");
		assertEquals(myBar.getRevenue(), 6.0, 0);
	}

}
