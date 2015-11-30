package gestionBar;
/**
 * Classe Beer
 */ 
 public class Beer implements Comparable<Beer>{
	 private final String name;
	 private final int price;
	 private final int degree;
	 private int stock; 
	 
	 
	 /**
	  * Constructeur avec arguments
	  * @param name : Représente le nom de la bière
	  * @param price : Un entier strictement supérieur à 0
	  * @param degree : Un entier strictement supérieur à 0
	  */
	 public Beer(String name, int price, int degree, int stock){
		 this.name=name;
		 this.price=price;
		 this.degree=degree;
		 this.stock=stock;
	 }

	/**
	 * @return Le nom de la bière
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Le prix de la bière, >0. 
	 */
	public int getPrice() {
		return price;
	}

 	/**
	 * @return Le degré de la bière, >0. 
	 */
	public int getDegree() {
		return degree;
	}

	/**
	 * Cette méthode permet de comparer deux bières
	 * sur base de leur degré d'alcool
	 * @param b : Un objet Beer non null
	 * @return 	une valeur négative si la bière courante a un degré d'alcool plus petit que b
	 * 			0 si les degrés d'alcool des deux bières sont identiques
	 * 			une valeur positive si la bière courante a un degré d'alcool supérieur à b
	 */
	public int compareTo(Beer b) {
		return this.degree-b.degree;
	}
	/**
	 * @return Le nombre de bouteilles en stock pour cette bière
	 */
	public synchronized int getStock() {
		return stock;
	}
	/**
	 * Cette méthode retire une bouteille du le stock si celui-ci n'est pas vide. 
	 * @throws InsufficientStockException : Si le stock est vide. 
	 */
	public synchronized void getBottle() throws InsufficientStockException{
		if(stock==0){
			throw new InsufficientStockException("Plus assez de stock"); 
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stock--;
		//System.out.println("Une " + this.name + " en moins dans le stock.  Reste "+stock + " bouteilles.");
	}
	/**
	 * Ajoute numBottles bouteilles de la bière courante dans le stock. 
	 * @param numBottles : entier positif. 
	 */
	public synchronized void addStock(int numBottles) {
		if(numBottles>0)
			this.stock+=numBottles;
	}
}
