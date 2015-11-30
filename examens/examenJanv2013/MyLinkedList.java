package reservation_vols;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

public class MyLinkedList<E> extends AbstractList<E> implements List<E> {
	private Node<E> start;
	private Node<E> end;
	private int curSize;//Number of non-null element of the list
	/*
	 * Constructeur sans argument
	 */
	public MyLinkedList(){
		start = new Node<E> (null);
		end=new Node<E>(null);
		start.setNext(end);
		end.setPrev(start);
		curSize=0;
	}
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	public E get(int index) {
		if(index<0 || index>=size()){
			throw new IndexOutOfBoundsException();
		}
		Node<E> tmp = start.getNext();
		for(int i=0; i<index; i++){
			tmp=tmp.getNext();
		}
		return tmp.getElement();
	}
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	public int size() {
		return curSize;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	public void add(int index, E item) {
		if(index<0 || index>size()){
			throw new IndexOutOfBoundsException();
		}
		Node<E> tmp = start;
		for(int i=0; i<index; i++){
			tmp=tmp.getNext(); //Tmp est le noeud avant index
		}
		//Creation du nouveau noeud
		Node<E> newNode = new Node<E>(item);
		newNode.setPrev(tmp);
		newNode.setNext(tmp.getNext());
		newNode.getNext().setPrev(newNode);
		tmp.setNext(newNode);
		curSize++;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#remove(int)
	 */
	public E remove(int index) {
		if(index<0 || index>=size()){
			throw new IndexOutOfBoundsException();
		}
		Node<E> tmp = start;
		for(int i=0; i<=index; i++){
			tmp=tmp.getNext(); //Tmp est le noeud situe a l'index specifie
		}
		E elem = tmp.getElement();
		tmp.getPrev().setNext(tmp.getNext());
		tmp.getNext().setPrev(tmp.getPrev());
		curSize--;
		return elem;
		
	}


	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#set(int, java.lang.Object)
	 */
	public E set(int index, E item) {
		E elem = (E) this.remove(index);
		this.add(index,item);
		return elem;
	}
}
