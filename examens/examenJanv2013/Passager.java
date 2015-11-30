package reservation_vols;

public class Passager extends Personne{
	int numClient;
	int points;
	public Passager(String nom, String prenom, int numId, int numClient) {
		super(nom, prenom, numId);
		this.numClient = numClient;
		this.points = 0; 
	}
}
