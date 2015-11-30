package devoirCollection;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> extends AbstractList<E>   {
	private Object[] list; 
	private int initCapacity=100;
	private int curSize;//Number of non-null element of the list
	/*
	 * Constructeur sans argument. 
	 */
	public MyArrayList(){
		list = new Object[initCapacity];
		curSize=0;
	}
	/*
	 * Constructeur permettant de construire une liste sur base de la collection en param?tre.
	 */
	public MyArrayList(Collection<E> c){
		this();
		for(E item : c){ //Puisqu'une collection est iterable, on peut utiliser le foreach.
			this.add(item);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	public E get(int index) {
		return (E) list[index];
	}
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	public int size() {
		return curSize;
	}
	/*
	 * Attention : i doit ?tre dans le range d'indices de la liste, ou juste apr?s (0<=i<=list.size())
	 * Dans le cas contraire, une exception est lanc?e. 
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	public void add(int i, E item) {
		if(i<0 || i>this.size())
			throw new IndexOutOfBoundsException();
		//1. V?rification de la taille de l'array, doublement si n?cessaire
		if(curSize==list.length){
			Object [] tmp = new Object [curSize*2];
			System.arraycopy(list, 0, tmp, 0, curSize);
			list=tmp;
		}
		//2. D?calage des ?l?ments du tableau ? partir de i
		for(int j = curSize; j>i; j--){
			list[j]=list[j-1];
		}
		//3. Insertion du nouvel ?l?ment
		list[i]=item;
		//4. Mise ? jour du nombre d'?l?ments
		curSize++;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#remove(int)
	 */
	public E remove(int index) {
		//1. R?cup?ration de l'?l?ment ? enlever
		E tmp = get(index);
		//2. Suppression de l'?l?ment de la liste
		list[index]=null;
		//3. D?calage des autres ?l?ments du tableau, vers la gauche. 
		for(int i=index+1; i<curSize; i++){
			list[i-1]=list[i];
		}
		curSize--;
		//4. On renvoie l'?l?ment 
		return tmp;
	}


	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#set(int, java.lang.Object)
	 */
	public E set(int index, E item) {
		E tmp = (E)list[index];
		list[index]=item;
		return tmp;
	}
	
}
