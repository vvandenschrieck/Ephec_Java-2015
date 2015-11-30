package devoirCollection;

import java.util.AbstractList;
import java.util.Iterator;

public class TestMyLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//AbstractList<Integer> list = new MonArrayList<Integer>();
		AbstractList<Integer> list = new MyLinkedList<Integer>();
		list.add(12);
		list.add(11);
		list.add(2);
		list.add(-1);
		list.add(0);
		System.out.println("Taille de la liste (attendu : 5): " + list.size());
		System.out.println("Impression de la liste avec boucle.  Resultat attendu : 12 11 2 -1 0");
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+" ");
		System.out.println();
		System.out.println("Impression de la liste avec iterateur.  Resultat attendu : 12 11 2 -1 0");
		
		Iterator<Integer> it2 = list.iterator();
		while(it2.hasNext())
			System.out.print(it2.next()+ " ");
		
		System.out.println();
		System.out.println("Impression de la liste avec toString.  Resultat attendu : [12 11 2 -1 0]");
		System.out.println(list);
		System.out.println();
		System.out.println("Retrait de l'element d'indice 1.  Valeur renvoyee attendue : 11");
		System.out.println(list.remove(1));
		System.out.println("Affichage de la liste apres retrait.  Resultat attendu : [12 2 -1 0]");
		System.out.println(list);
		System.out.println();
		System.out.println("Taille de la liste a ce stade (attendu : 4) : "+ list.size());
		
		
		System.out.println("Remplacement de l'element d'indice 1. Resultat renvoye attendu : 2");
		System.out.println(list.set(1,  3));
		System.out.println("Impression de la liste apres remplacement.  Resultat attendu : [12 3 -1 0]");
		System.out.println(list);
	
		System.out.println();
		list.add(1,  1);
		System.out.println("Impression de la liste apres ajout a l'index 1.  Resultat attendu : [12 1 3 -1 0]");
		System.out.println(list);
		System.out.println();
		System.out.println("Test de l'ajout avec index en dehors des valeurs autorisees.  Resultat attendu : IndexOutOfBoundsException") ;
		try{
			list.add(10, 1);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Ok, IndexOutOfBoundsException lancee");
		}
		System.out.println("Test de remove en dehors des valeurs autorisees.  Resultat attendu : IndexOutOfBoundsException") ;
		try{
			list.remove(10);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Ok, IndexOutOfBoundsException lancee");
		}
		System.out.println("Test d'une methode de la super-classe (AbstractList).  Resultat attendu : liste doit etre vide");
		list.clear();
		System.out.println("Taille de la liste apres nettoyage : "+list.size());
	}

}
