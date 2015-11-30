package cookies.magasin;

public class Cookie {
	public final double BENEFICE = 0.25;
	RecetteCookie recette; 
	public Cookie(RecetteCookie recette) {
		this.recette = recette;
	}
	
	public double prix(){
		return recette.cout() * (1+BENEFICE);
	}
	public String toString(){
		return this.recette.getDescriptif() + " - " + prix();
	}
}
