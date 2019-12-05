/**
* @Author pzh
* @Date 2019年10月20日 上午11:50:20
* @Description 
*/
package com.pzh.tree.huffmancode;
public class Node implements Comparable<Node>{
	
	private Byte data;
	private int weight;
	private Node left;
	private Node right;
	
	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	public Byte getData() {
		return data;
	}

	public void setData(Byte data) {
		this.data = data;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Node o) {

		return o.weight - this.weight;
	}
	
	
}
