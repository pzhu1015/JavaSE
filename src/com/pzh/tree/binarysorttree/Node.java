/**
* @Author pzh
* @Date 2019年10月21日 下午10:21:45
* @Description 
*/
package com.pzh.tree.binarysorttree;
public class Node {
	private int value;
	private Node left;
	private Node right;
	
	
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


	public Node(int value) {
		super();
		this.value = value;
	}


	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (node.getValue() < value) {
			if (left == null) {
				left = node;
			}else {
				left.add(node);
			}
		}else {
			if (right == null) {
				right = node;
			}else {
				right.add(node);
			}
		}
	}


	public void midShow(Node node) {
		
		if (node == null) {
			return;
		}
		midShow(node.left);
		System.out.println(node.getValue());
		midShow(node.right);
	}


	public Node search(int value) {
		
		if (this.value == value) {
			return this;
		}else if (value < this.value) {
			if (left == null) {
				return null;
			}
			return left.search(value);
		}else {
			if (right == null) {
				return null;
			}
			return right.search(value);
		}
	}


	public Node searchParent(int value) {
		
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		}else {
			if (this.value > value && this.left != null) {
				return this.left.searchParent(value);
			}else if(this.value < value && this.right != null){
				return this.right.searchParent(value);
			}
		}
		
		return null;
	}


}
