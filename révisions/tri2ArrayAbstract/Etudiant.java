package tri2ArrayAbstract;

public class Etudiant extends Personne{

	
	public final static double TAX = 0.06; // rappels sur dinal, static
	private double salaire;
	
	public Etudiant(String nom, String niss, double taille, double salaire) { // généré eclipse
		super(nom, niss, taille);
		this.salaire = salaire;
	}

	@Override // généré eclipse // rappel super
	public String toString() {
		return super.toString() + " Etudiant [salaireNet=" + calculerSalaireNet() + "]"; // attention affiche salaire net
	}

	@Override
	public double calculerSalaireNet() { // généré eclipse
		
		return this.salaire * (1 - Etudiant.TAX); // plus logique de l'utiliser sur la classe et non l'instance
	}
	
	
	
	
	
	
	
}




/*
public Etudiant(String nom, String niss, double taille, double salaire) {
super(nom, niss, taille);
this.salaire = salaire;	
}

@Override
public double calculerSalaireNet() {

return this.salaire * (1 - Etudiant.TAX);
}

@Override
public String toString() {
return super.toString() + "Etudiant [salaireNet=" + calculerSalaireNet() + "]";
}

*/