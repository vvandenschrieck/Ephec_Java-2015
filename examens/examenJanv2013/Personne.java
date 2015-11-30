package reservation_vols;

public class Personne {
	private String nom;
	private String prenom;
	private int numId;
	
	/**
	 * @param id est un entier positif
	 * Creation d'une nouvelle personne
	 */
	public Personne(String nom, String prenom, int numId){
		this.nom = nom; 
		this.prenom = prenom;
		this.numId = numId; 
	}
	public String toString(){
		return this.nom + " " +this.prenom + " - " + this.numId;
	}
	/*
	 * L'equivalence entre deux personnes s'effectue sur base 
	 * du numero d'identite 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o){
		if(this == o) return true;
		if ( !(o instanceof Personne) ) return false;
		return  ((Personne)o).numId== this.numId;
	}
}
