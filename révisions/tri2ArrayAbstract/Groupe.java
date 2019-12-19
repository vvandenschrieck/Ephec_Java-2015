package tri2ArrayAbstract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Groupe {

	private List<Personne> mesPersonnesList = new ArrayList<Personne>();
	
		
	public static void main(String[] args) {
	   
	    Groupe groupe = new Groupe();
	    
	    Personne personne1 = new Etudiant("toto", "11", 180, 200); // Etudiant dans liste de personnes ok
	    Personne personne2 = new Etudiant("tata", "22", 170, 150);
	    
	    groupe.mesPersonnesList.add(personne1);
	    groupe.mesPersonnesList.add(personne2);
	    
	    for (Personne p : groupe.mesPersonnesList) {
	    	System.out.println(p);
	    }
	    
	   // tri
	    Collections.sort(groupe.mesPersonnesList);
	    
	    for (Personne p : groupe.mesPersonnesList) {
	    	System.out.println(p);
	    }

	}

}
