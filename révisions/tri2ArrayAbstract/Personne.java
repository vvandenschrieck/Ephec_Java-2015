package tri2ArrayAbstract;

public abstract class Personne implements Comparable<Personne>{
	
	private String nom;
	private String niss;
	private double taille;
			
	public Personne(String nom, String niss, double taille) {
		super();
		this.nom = nom;
		this.niss = niss;
		this.taille = taille;
	}

	public abstract double calculerSalaireNet();
	
	@Override
	public int compareTo(Personne personne) {
		return Double.compare(this.calculerSalaireNet(), personne.calculerSalaireNet()); // peut utiliser méthode abstraite
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", niss=" + niss + ", taille=" + taille + "]";
	}
	
}
