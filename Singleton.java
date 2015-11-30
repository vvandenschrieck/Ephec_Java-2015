public final class Singleton {
	
	// Variable de classe pour stocker l’instance
	private static Singleton instance;
	
	// Constructeur privé
	private Singleton (){}

	// Méthode de classe pour récupérer l’ instance
	public synchronized static Singleton getInstance(){
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
}