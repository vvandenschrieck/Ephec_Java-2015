package gestionBarTest;
import static org.junit.Assert.*;
import gestionBar.Beer;
import gestionBar.BeerLinkedList;
import gestionBar.BeerNotFoundException;

import org.junit.Before;
import org.junit.Test;


public class BeerLinkedListTest {
	BeerLinkedList list; 
	Beer chimay, westmalle, orval, jupiler; 
	@Before
	public void setUp() throws Exception {
		chimay = new Beer("Chimay", 2, 10, 1);
		westmalle = new Beer("Westmalle", 2, 10, 1);
		orval = new Beer("Orval", 2, 12, 1);
		jupiler = new Beer("Jupiler", 2, 5, 1);
		list = new BeerLinkedList(); 
		list.add(chimay);
		list.add(westmalle);
		list.add(orval);
		list.add(jupiler);
	}

	@Test
	public void testFindDegree() {
		assertNull(list.find(2));
		assertEquals(list.find(10), westmalle);
		assertEquals(list.find(12), orval);
		assertEquals(list.find(13), orval);
		assertEquals(list.find(6), jupiler);	
		
	}
	@Test
	public void testFindName() throws BeerNotFoundException{
		assertEquals(list.find("Jupiler"), jupiler);
		assertEquals(list.find("Westmalle"), westmalle);
	}
	@Test(expected=BeerNotFoundException.class)
	public void testFindNameNotFound() throws BeerNotFoundException{
		list.find("Westvleteren");
	}

}
