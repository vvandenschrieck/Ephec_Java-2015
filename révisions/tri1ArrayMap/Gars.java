package tri1ArrayMap;

public class Gars implements Comparable<Gars> { // d'abord montrer sans <Gars> avec cast dans Comparable
	
	private String nom;
	private String niss;
	private double taille;
		
	public Gars(String nom, String niss, double taille) { // généré Eclipse
		super();
		this.nom = nom;
		this.niss = niss;
		this.taille = taille;
	}

	@Override  // généré Eclipse
	public int compareTo(Gars gars) { // au début avec Object
		return Double.compare(this.taille, gars.taille); // montré/discuté comment le faire à la main
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