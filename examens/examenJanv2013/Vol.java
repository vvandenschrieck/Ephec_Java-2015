package reservation_vols;
import java.util.ArrayList;
import java.util.List;

public class Vol {
	private String ligne;
	private List<Personne> listePassagers; 
	private int numPlaces;
	public Vol(String ligne, int numPlaces){
		this.listePassagers = new ArrayList	<Personne>(); 
		this.numPlaces = numPlaces;
		this.ligne = ligne;
	}
	/**
	 * Cette methode ajoute un passager au vol. L'objet courant est donc modifie, et le nombre de places
	 * disponibles est decremente.  
	 * @param p : une Personne, non null.  
	 * @throws VolCompletException si toutes les places du vol ont ete reservees
	 * @throws DejaEnregistreException si la personne specifiee est deja enregistree sur le vol
	 */
	public void ajoutePassager(Personne p) throws VolCompletException, DejaEnregistreException{
		if(listePassagers.contains(p)){
			throw new DejaEnregistreException("Le passager "+ p + " est deja enregistre sur le vol");
		}
		if(this.estComplet()){
			throw new VolCompletException("Plus de place sur le vol" + this);
		}
		listePassagers.add(p);
	}
	/**
	 * Renvoie une representation sous forme de chaine de caractere du vol, 
	 * avec l'etat de remplissage du vol et le nom des passagers enregistres
	 */
	public String toString(){
		String result = "=== Vol "+ ligne + " ===\n";
		result += ("\ttotal : \t" + this.numPlaces + " places\n");
		result += ("\treservees : \t" + this.listePassagers.size() + " places\n"); 
		result += ("\tListe des passagers : \n");
		for(Personne p : listePassagers)
			result += ("- "+ p + "\n"); 
		return result;
	}
	/**
	 * Deux vols sont equivalent si le nom de la ligne est identique
	 */
	public boolean 	equals(Object o){
		if(this == o) return true;
		if ( !(o instanceof Vol) ) return false;
		return ((Vol)o).ligne == this.ligne;
	}
	/**
	 * @return true si le vol est complet et qu'il n'y a plus de reservation possible
	 */
	public boolean estComplet() {
		return listePassagers.size()==this.numPlaces;
	}
	public static void main(String[] args) {
		Vol ParisBxl =  new Vol("Paris - Bruxelles", 1); 
		Personne moi = new Personne("Virginie", "Van den Schrieck", 12345);
		Personne lui = new Personne("Edgar", "Tartempion", 12312);
		try {
			ParisBxl.ajoutePassager(moi);
			ParisBxl.ajoutePassager(moi);
		} catch (VolCompletException | DejaEnregistreException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(ParisBxl);
		
	}
	

}
