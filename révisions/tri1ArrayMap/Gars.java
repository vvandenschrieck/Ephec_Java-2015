package tri1ArrayMap;

public class Gars implements Comparable<Gars> { // d'abord montrer sans <Gars> avec cast dans Comparable
	
	private String nom;
	private String niss;
	private double taille;
		
	public Gars(String nom, String niss, double taille) { // g�n�r� Eclipse
		super();
		this.nom = nom;
		this.niss = niss;
		this.taille = taille;
	}

	@Override  // g�n�r� Eclipse
	public int compareTo(Gars gars) { // au d�but avec Object
		return Double.compare(this.taille, gars.taille); // montr�/discut� comment le faire � la main
	}

	@Override
	public String toString() {
		return "Gars [nom=" + nom + ", niss=" + niss + ", taille=" + taille + "]";
	}

	public String getNom() {
		return nom;
	}


	public String getNiss() {
		return niss;
	}


	public double getTaille() {
		return taille;
	}
	

}