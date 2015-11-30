package devoirCollection;

import static org.junit.Assert.*;

import java.util.AbstractList;

import org.junit.Before;
import org.junit.Test;

import unittest.NonPositiveException;

public class UnitTestMyLinkedList {
	AbstractList<Integer> list;
	@Before
	public void setUp() throws Exception {
		list = new MyLinkedList<Integer>();
		
	}

	@Test
	public void testAdd() {
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals("[1, 2, 3]", list.toString());
	}
	@Test
	public void testSize(){
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(3, list.size());
	}
	@Test
	public void testSet(){
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(1, (int)list.set(0, 0));
		assertEquals("[0, 2, 3]", list.toString());
		
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetExcep1(){
		list.add(1);
		list.add(2);
		list.add(3);
		list.set(-1,5);
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetExcep2(){
		list.add(1);
		list.add(2);
		list.add(3);
		list.set(3,5);
	}
	@Test
	public void testRemove(){
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(1, (int)list.remove(0));
		assertEquals("[2, 3]", list.toString());	
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveExcep1(){
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(-1);
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveExcep2(){
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(4);
	}

}
