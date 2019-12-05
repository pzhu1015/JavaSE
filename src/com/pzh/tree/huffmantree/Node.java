/**
* @Author pzh
* @Date 2019年10月19日 下午10:23:19
* @Description 
*/
package com.pzh.tree.huffmantree;
public class Node implements Comparable<Node>{

	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	@Override
	public int compareTo(Node o) {
		return o.value -  this.value;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
}
