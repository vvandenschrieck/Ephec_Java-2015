package gestionBar;

public class Bar {
	private float revenue; 
	private BeerLinkedList list; 
	
	/*
	 * Constructeur sans paramètre.   
	 */
	public Bar(){
		list = new BeerLinkedList();	
	}
	/**
	 * Ajoute une nouvelle bière au stock. 
	 * @param name : Le nom de la nouvelle bière.  Doit être != null. 
	 * @param degree : Le degré de la bière name.  Doit être positif. 
	 * @param price : Le prix de la bière name.  Doit être positif. 
	 */
	public void addBeer(String name, int degree, int price){
		list.add(new Beer(name, price, degree, 0)); 
	}
	/**
	 * Ajoute numBottles bouteilles de la bière name au stock
	 * @param name : Nom de la bière contenue dans les bouteilles. Doit être != null; 
	 * @param numBottles : Nombre de bouteilles à ajouter.  Doit être >0. 
	 * @throws BeerNotFoundException : Si la bière n'existe pas dans le stock. 
	 */
	public void addStock(String name, int numBottles) throws BeerNotFoundException {
		Beer beer = list.find(name);
		beer.addStock(numBottles);	
	}
	/**
	 * 
	 * @param name : Nom de la bière à trouver.  Doit être != null
	 * @return Le prix d'une bouteille de bière de nom name. 
	 * @throws BeerNotFoundException si la bière n'existe pas dans le stock. 
	 */
	public float getPrice(String name) throws BeerNotFoundException{
		return list.find(name).getPrice(); 
	}
	/**
	 * Cette méthode permet de servir une bière à un client, et 
	 * d'encaisser le prix correspondant.
	 * @param name : Le nom d'une bière. 
	 * @throws BeerNotFoundException : Si la bière n'est pas servie dans le bar
	 * @throws InsufficientStockException : Si la bière n'est plus en stock
	 */
	public void serve(String name) throws BeerNotFoundException, 
											InsufficientStockException{
		Beer beer = list.find(name); 
		beer.getBottle();
		synchronized(this){
			revenue+=beer.getPrice();
		}
	}
	/**
	 * Renvoie la recette actuelle du bar. 
	 */
	public float getRevenue(){
		return this.revenue;
	}
}
