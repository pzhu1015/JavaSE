/**
* @Author pzh
* @Date 2019年9月18日 下午10:07:50
* @Description 
*/
package com.pzh.list;


public final class SingleLinkedList<E>{
	
	private final static class Node<E>{
		E element;
		Node<E> next;
		Node(E e){
			this.element = e;
		}
	}
	
	int size = 0;
	private Node<E> head;

	public boolean add(E e) {

		Node<E> node = new Node<>(e);
		if (head == null) {
			head = node;
		} else {
			Node<E> n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
		
		return true;
	}

	public void add(int index, E e) {

		sanityCheck(index);
		Node<E> node = getNode(index);
		Node<E> n = new Node<>(e);
		n.next = node.next;
		node.next = n;
		size ++;
	}

	public E get(int index) {
		
		Node<E> node = getNode(index);
		return node.element;
	}

	public E remove(int index) {

		sanityCheck(index);
		Node<E> node = getNode(index);
		Node<E> n = head;
		for (int i=0; i< index -1; i++) {
			n = n.next;
		}
		n.next = node.next;
		node.next = null;
		size--;
		return node.element;
	}

	public void clear() {
		
		size = 0;
		head = null;
	}
	
	public int size() {
		
		return size;
	}
	
	private Node<E> getNode(int index){
		
		sanityCheck(index);
		Node<E> node = head;
		for (int i=0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	public void reverse() {
		
		Node<E> pre = head;
		Node<E> cur = head.next;
		Node<E> next;
		
		while(cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		head.next = null;
		head = pre;
	}
	
	private void sanityCheck(int index) {
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
		}
	}
}
