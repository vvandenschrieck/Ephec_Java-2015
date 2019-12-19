package tri1ArrayMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Groupe {

	private List<Gars> mesGarsList = new ArrayList<Gars>();
	
	private Map<String,Gars> mesGarsMap = new HashMap<String,Gars>();
	
	
	public static void main(String[] args) {
	    Gars gars1 = new Gars("toto", "11", 180);
	    Gars gars2 = new Gars("tata", "22", 170);
	    
	    Groupe groupe = new Groupe();
	    
	    groupe.mesGarsList.add(gars1);
	    groupe.mesGarsList.add(gars2);	    
	    
	    for (Gars gars : groupe.mesGarsList) {
	    	System.out.println(gars);
	    }
	    
	   // une façon de trier
	    Collections.sort(groupe.mesGarsList);
	    
	    for (Gars gars : groupe.mesGarsList) {
	    	System.out.println(gars);
	    }
	    
	    System.out.println();
	    System.out.println("--------------------");
	    System.out.println();
	    
	    
	    
	    // *******************************
	    
	    // passer d'un map à une liste
	    groupe.mesGarsMap.put(gars1.getNiss(), gars1); // remove possible
	    System.out.println(groupe.mesGarsMap.get("11"));
	    System.out.println();
	    groupe.mesGarsMap.put(gars2.getNiss(), gars2); 
	    
	    groupe.mesGarsList = new ArrayList<Gars>(groupe.mesGarsMap.values()); // une façon de passer d'un map à un array
	    
	    for (Gars gars : groupe.mesGarsList) {
	    	System.out.println(gars);
	    }
	    
	   // tri
	    Collections.sort(groupe.mesGarsList);
	    
	    for (Gars gars : groupe.mesGarsList) {
	    	System.out.println(gars);
	    }
	    
	    System.out.println();
	    
	    // *******************************

	}

}
