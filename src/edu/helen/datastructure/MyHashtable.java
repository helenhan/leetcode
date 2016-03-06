package edu.helen.datastructure;

import java.util.LinkedList;

public class MyHashtable<K,V> {
	private final int MAX_SIZE = 10;
	private LinkedList<Cell<K,V>> [] items = null;

	public MyHashtable() {
		items = new LinkedList[MAX_SIZE];
	}
	
	public int hashcodeOfKey(K key){
		return key.toString().length()%items.length;
	}
	
	public void put(K key, V value){
		int hash = hashcodeOfKey(key);
		LinkedList<Cell<K,V>> collid = items[hash];
		if(collid==null){
			
		}
	}

	public static void main(String[] args) {

	}

}

class Cell<K,V>{
	private K key;
	private V value;
	
	public Cell(K key, V value){
		this.key = key;
		this.value = value;
	}
}