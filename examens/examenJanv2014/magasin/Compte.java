package cookies.magasin;

public final class Compte {
	private double solde;
	private static Compte uniqueInstance  = null;
	
	private Compte() {
	}
	public final static Compte getInstance(double soldeInitial) {
		if (uniqueInstance == null) {
			uniqueInstance = new Compte(); }
			uniqueInstance.solde = soldeInitial;
			return uniqueInstance;
	}
	
	public void retrait(double montant) throws SoldeInsuffisantException{
		if(solde >= montant){
			solde = solde - montant;
		}
		else {
			throw new SoldeInsuffisantException();
		}
		
	}
	
	public void depot(double montant){
		solde = solde + montant;
	}

	public double solde() {
		return solde;
	}	
	
	public String toString(){
		return "Solde du compte : " + solde;
	}
}
