package gestionBar;
// BeerLinkedList.java
/**
 * Cette classe définit une liste chaînée permettant de stocker des bières de manière ordonnée, suivant leur degré d'alcool (ordre croissant)  
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
	 * Cette méthode ajoute une bière à la liste, en respectant l'ordre des degrés.  
	 * @param b : Une bière != null. 
	 */
	public void add(Beer b)
	{
		Node newNode = new Node(b);
		if (first == null)
		{
			first = newNode;
		}
		//Si la nouvelle bière a le plus bas degré d'alcool : mise à jour de first. 
		else if (first.beer.compareTo(newNode.beer) > 0)
		{
			newNode.next = first;
			first = newNode;
		}
		else
		{
			Node current = first;
			//Parcours de la liste pour trouver la première bière de degré supérieur à la nouvelle
			//(ou à défaut, jusqu'à la fin)
			while (current.next != null && current.next.beer.compareTo(newNode.beer) < 0)
			{
				current = current.next;
			}
			//Insertion de la nouvelle bière à l'emplacement ad-hoc. 
			newNode.next = current.next;
			current.next = newNode;
		}
	}
	/**
	 * Cette méthode trouve la bière dont le degré est égale au paramètre indiqué, ou à défaut, 
	 * la bière de degré strictement inférieur
	 * @param degree : un entier strictement positif
	 * @return la bière dont le degré s'approche le plus de degree s'il en existe une, ou null à défaut. 
	 */
	public Beer find (int degree)
	{
		//La recherche échoue si la liste est vide ou ne contient que des bières de degré supérieur à celui demandé
		if(first == null || first.beer.getDegree() > degree)
			return null;
		
		//Parcours de la liste jusqu'à trouver une bière de degré supérieur ou égal à celui demandé. 
		Node current = first;
		while(current.next != null && current.next.beer.getDegree() <= degree){
			current=current.next;
		}
		//System.out.println("Found for degree " + degree + " : "+ current.beer.getName());
		return current.beer;
	}
	/**
	 * Cette méthode permet de trouver une bière sur base de son nom. 
	 * @param name : Une chaîne de caractère non vide représentant le nom de la bière
	 * @return La bière portant le nom 
	 * @throws BeerNotFoundException
	 */
	public Beer find (String name) throws BeerNotFoundException
	{
		Node current=first;
		//Parcourt de la liste jusqu'à la fin, ou jusqu'à trouver la bière recherchée
		while(current != null && ! current.beer.getName().equals(name)){
			current=current.next;
		}
		//Vérification du résultat de la recherche
		if(current == null)
			throw new BeerNotFoundException();
		return current.beer;
		
		
	}
	/**
	 * Cette méthode fournit une représentation textuelle de la liste de bière. 
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
	 * Noeud de la liste simplement chaînée
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