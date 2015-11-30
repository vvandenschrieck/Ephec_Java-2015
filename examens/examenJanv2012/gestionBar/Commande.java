package gestionBar;


/**
 * Classe simulant un serveur exécutant des commandes au bar. 
 * @author V. Van den Schrieck 
 */
public class Commande extends Thread {
	private static int total=0;
	private int numCommand=0;
	private String beerName;
	private int numBottles;
	private Bar bar; 
	/**
	 * Constructeur avec nom du serveur en argument
	 */
	public Commande(Bar b, String name, int num){
		super();
		this.beerName=name;
		this.numBottles=num;
		numCommand=total+1; 
		total=total+1;
		bar = b; 
	}
	@Override
	public void run() {
		int i=0;
		try{
			for(i=0; i < numBottles; i++){
				bar.serve(beerName);
			}
		}
		catch(InsufficientStockException e){
			System.out.println("Erreur : Stock insuffisant.  Seules "+(i) + " bières ont pu être servies pour la commande "+numCommand);
		}
		catch(BeerNotFoundException e){
			System.out.println("Erreur : Bière inconnue");
		} 
	}
	
}
