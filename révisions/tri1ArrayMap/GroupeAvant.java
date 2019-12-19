package tri1ArrayMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Groupe {

	private List mesGarsList; // quel type ? quelle implémentation ? quel contenu ? comment initialiser ?
	
	private Map mesGarsMap;
		
	
	
	public static void main(String[] args) {
		
	    Gars gars1 = new Gars("toto", "11", 180);
	    Gars gars2 = new Gars("tata", "22", 170);
	    
	    Groupe groupe = new Groupe();
	    
	    groupe.mesGarsList.add(gars1);
	    groupe.mesGarsList.add(gars2);	    
	    
	    
	    for (Gars gars : groupe.mesGarsList) {
	    	System.out.println(gars);
	    }
	    
	   // comment trier ?
	   
	    for (Gars gars : groupe.mesGarsList) {
	    	System.out.println(gars);
	    }
	    
	}

}
