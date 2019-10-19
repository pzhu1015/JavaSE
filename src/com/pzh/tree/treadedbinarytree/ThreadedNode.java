/**
* @Author pzh
* @Date 2019年10月19日 下午1:27:41
* @Description 
*/
package com.pzh.tree.treadedbinarytree;

public class ThreadedNode {
	private int value;
	private int leftType;
	private int rightType;
	private ThreadedNode leftNode;
	private ThreadedNode rightNode;

	public ThreadedNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ThreadedNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(ThreadedNode leftNode) {
		this.leftNode = leftNode;
	}

	public ThreadedNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(ThreadedNode rightNode) {
		this.rightNode = rightNode;
	}

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public void beforeShow() {

		System.out.println(value);
		if (leftNode != null) {
			leftNode.beforeShow();
		}
		if (rightNode != null) {
			rightNode.beforeShow();
		}
	}

	public void midShow() {

		if (leftNode != null) {
			leftNode.midShow();
		}
		System.out.println(value);
		if (rightNode != null) {
			rightNode.midShow();
		}
	}

	public void afterShow() {

		if (leftNode != null) {
			leftNode.afterShow();
		}
		if (rightNode != null) {
			rightNode.afterShow();
		}
		System.out.println(value);
	}
}
