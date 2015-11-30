package gestionBar;

public class TestBar {
	public static void main(String [] args) throws BeerNotFoundException, InterruptedException{
		Bar monBar = new Bar();
		monBar.addBeer("Chimay",9,2);
		monBar.addBeer("Westmalle", 10, 3);
		monBar.addStock("Chimay", 10);
		monBar.addStock("Westmalle", 5);
		
		Commande c1 = new Commande(monBar, "Chimay", 5);
		Commande c4 = new Commande(monBar, "Westmalle", 3);
		Commande c2 = new Commande(monBar, "Chimay", 5);
		Commande c3 = new Commande(monBar, "Chimay", 5);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c1.join(); 
		c2.join();
		c3.join();
		c4.join();
		System.out.println("Recette du bar : "+monBar.getRevenue());
	}
	
	
	
}
