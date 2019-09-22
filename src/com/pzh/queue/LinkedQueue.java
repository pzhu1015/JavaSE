/**
* @Author pzh
* @Date 2019年9月16日 下午11:58:27
* @Description 
*/
package com.pzh.queue;

import java.util.NoSuchElementException;

interface Queue<E> {

	/**
	 * Inserts the specified element into this queue if it is possible to do so 
	 * immediately without violating capacity restrictions, returning true upon
	 * success and throwing an IllegalStateException if no space is currently
	 * available.
	 * @param e
	 * @return
	 */
	boolean add(E e);

	/**
	 * Retrieves, but does not remove, the head of this queue.
	 * @return
	 */
	E element();

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions.
	 * @param e
	 * @return
	 */
	boolean offer(E e);

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if 
	 * this queue is empty.
	 * @return
	 */
	E peek();

	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue
	 * is empty.
	 * @return
	 */
	E poll();

	/**
	 * Retrieves and removes the head of this queue.
	 * @return
	 */
	E remove();
}

public final class LinkedQueue<E> implements Queue<E> {
	private final static class Node<E> {

		E element;
		Node<E> next;

		Node(E e) {
			this.element = e;
		}
	}

	private Node<E> head = null;
	private Node<E> tail = null;

	
	@Override
	public boolean offer(E e) {

		Node<E> node = new Node<>(e);
		if (head == null) {
			head = node;
		} else {
			tail.next = node;
		}
		tail = node;
		return true;
	}

	@Override
	public E peek() {

		if (head == null) {
			return null;
		}
		return head.element;
	}

	@Override
	public E poll() {

		if (head == null) {
			return null;
		}

		E item = head.element;
		head = head.next;
		return item;
	}

	@Override
	public E remove() {

		if (head == null) {
			throw new NoSuchElementException();
		}

		E item = head.element;
		head = head.next;
		return item;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E element() {

		if (head == null) {
			return null;
		}
		return head.element;
	}
	
	@Override
	public String toString() {

		if (head == null) {
			return "[null]";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			Node<E> node = head;
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
