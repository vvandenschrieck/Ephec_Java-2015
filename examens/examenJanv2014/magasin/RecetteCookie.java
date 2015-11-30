package cookies.magasin;

public class RecetteCookie {
	private String descriptif;
	private ListeIngredients ingredients;
	
	public RecetteCookie(String descriptif) {
		super();
		this.descriptif = descriptif;
		ingredients = new ListeIngredients();
	}
	
	public ListeIngredients getIngredients() {
		return ingredients;
	}
	public void addIngredient(Ingredient i, int quantite){
		ingredients.ajouter(i, quantite);
	}	
	public double cout(){
		return ingredients.valeurIngredients();
	}	

	@Override
	public String toString() {
		return "Cookie [descriptif=" + descriptif + ", prix()=" + cout() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descriptif == null) ? 0 : descriptif.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecetteCookie other = (RecetteCookie) obj;
		if (descriptif == null) {
			if (other.descriptif != null)
				return false;
		} else if (!descriptif.equals(other.descriptif))
			return false;
		return true;
	}


	public String getDescriptif() {
		return descriptif;
	}
	
}
