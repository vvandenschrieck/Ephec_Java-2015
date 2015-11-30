package cookies.magasin;

public class Ingredient {
	String name;
	double qteBaseGr;
	double prixKilo;
	
	public Ingredient(String name, double qteBaseGr, double prixKilo) {
		super();
		this.name = name;
		this.qteBaseGr = qteBaseGr;
		this.prixKilo = prixKilo;
	}
	
	public String getName() {
		return name;
	}

	public double getPrixUnitaire() {
		return (prixKilo/1000.0)*qteBaseGr;
	}
	public String toString(){
		return name;
	}
	public double getNbUniteParKilo(){
		return 1000.0/qteBaseGr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
