package gestionBar;
// BeerLinkedList.java
/**
 * Cette classe d�finit une liste cha�n�e permettant de stocker des bi�res de mani�re ordonn�e, suivant leur degr� d'alcool (ordre croissant)  
 * @author S. Combefis, V. Van den Schrieck
 *
 */
public class BeerLinkedList
{
	private Node first;
	/**
	 * Constructeur sans argument
	 */
	public BeerLinkedList()
	{
		first = null;
	}
	/**
	 * Cette m�thode ajoute une bi�re � la liste, en respectant l'ordre des degr�s.  
	 * @param b : Une bi�re != null. 
	 */
	public void add(Beer b)
	{
		Node newNode = new Node(b);
		if (first == null)
		{
			first = newNode;
		}
		//Si la nouvelle bi�re a le plus bas degr� d'alcool : mise � jour de first. 
		else if (first.beer.compareTo(newNode.beer) > 0)
		{
			newNode.next = first;
			first = newNode;
		}
		else
		{
			Node current = first;
			//Parcours de la liste pour trouver la premi�re bi�re de degr� sup�rieur � la nouvelle
			//(ou � d�faut, jusqu'� la fin)
			while (current.next != null && current.next.beer.compareTo(newNode.beer) < 0)
			{
				current = current.next;
			}
			//Insertion de la nouvelle bi�re � l'emplacement ad-hoc. 
			newNode.next = current.next;
			current.next = newNode;
		}
	}
	/**
	 * Cette m�thode trouve la bi�re dont le degr� est �gale au param�tre indiqu�, ou � d�faut, 
	 * la bi�re de degr� strictement inf�rieur
	 * @param degree : un entier strictement positif
	 * @return la bi�re dont le degr� s'approche le plus de degree s'il en existe une, ou null � d�faut. 
	 */
	public Beer find (int degree)
	{
		//La recherche �choue si la liste est vide ou ne contient que des bi�res de degr� sup�rieur � celui demand�
		if(first == null || first.beer.getDegree() > degree)
			return null;
		
		//Parcours de la liste jusqu'� trouver une bi�re de degr� sup�rieur ou �gal � celui demand�. 
		Node current = first;
		while(current.next != null && current.next.beer.getDegree() <= degree){
			current=current.next;
		}
		//System.out.println("Found for degree " + degree + " : "+ current.beer.getName());
		return current.beer;
	}
	/**
	 * Cette m�thode permet de trouver une bi�re sur base de son nom. 
	 * @param name : Une cha�ne de caract�re non vide repr�sentant le nom de la bi�re
	 * @return La bi�re portant le nom 
	 * @throws BeerNotFoundException
	 */
	public Beer find (String name) throws BeerNotFoundException
	{
		Node current=first;
		//Parcourt de la liste jusqu'� la fin, ou jusqu'� trouver la bi�re recherch�e
		while(current != null && ! current.beer.getName().equals(name)){
			current=current.next;
		}
		//V�rification du r�sultat de la recherche
		if(current == null)
			throw new BeerNotFoundException();
		return current.beer;
		
		
	}
	/**
	 * Cette m�thode fournit une repr�sentation textuelle de la liste de bi�re. 
	 */
	public String toString()
	{
		if (first == null)
		{
			return "[]";
		}
		Node current = first;
		String result = "[" + current.beer;
		while (current.next != null)
		{
			current = current.next;
			result += ", " + current.beer;
		}
		return result + "]";
	}
	/**
	 * Noeud de la liste simplement cha�n�e
	 * @author S. Combefis
	 *
	 */
	private class Node
	{
		private Node next;
		private final Beer beer;
		
		public Node (Beer beer)
		{
			next = null;
			this.beer = beer;
		}
	}

}