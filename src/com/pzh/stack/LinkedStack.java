/**
* @Author pzh
* @Date 2019年9月16日 下午11:22:35
* @Description 
*/
package com.pzh.stack;

interface Stack<E> {
	/**
	 * Tests if this stack is empty
	 * @return
	 */
	boolean empty();

	/**
	 * Looks at the object at the top of this stack without removing it from the stack
	 * @return
	 */
	E peek();

	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function
	 * @return
	 */
	E pop();

	/**
	 * Pushes an item into the top of this stack
	 * @param e
	 * @return
	 */
	E push(E e);

	/**
	 * Returns the 1 based position where an object is on this stack
	 * @param o
	 * @return
	 */
	int search(Object o);
}

public final class LinkedStack<E> implements Stack<E> {
	private final static class Node<E> {
		E element;
		Node<E> next;

		Node(E e) {
			this.element = e;
		}
	}

	private Node<E> head = null;

	

	@Override
	public E push(E e) {

		Node<E> node = head;
		head = new Node<>(e);
		head.next = node;
		return e;
	}

	@Override
	public E pop() {

		if (head == null) {
			return null;
		}
		E item = head.element;
		head = head.next;
		return item;
	}

	@Override
	public boolean empty() {

		return (head == null);
	}

	@Override
	public E peek() {

		if (head == null) {
			return null;
		}
		return head.element;
	}

	@Override
	public int search(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {

		if (head == null) {
			return "[null]";
		} else {
			Node<E> node = head;
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			while (true) {
				sb.append(node.element);
				node = node.next;
				if (node == null) {
					break;
				}
				sb.append(",");
			}
			sb.append("]");
			return sb.toString();
		}
	}
}
