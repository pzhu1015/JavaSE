/**
* @Author pzh
* @Date 2019年9月25日 下午7:44:16
* @Description 
*/
package com.pzh.tree.binarytree;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	TreeNode(int data) {
		this.data = data;
	}

	public void beforeShow() {
		System.out.println(data);
		if (left != null) {
			left.beforeShow();
		}
		if (right != null) {
			right.beforeShow();
		}
	}

	public void midShow() {
		if (left != null) {
			left.midShow();
		}
		System.out.println(data);
		if (right != null) {
			right.midShow();
		}
	}

	public void afterShow() {
		if (left != null) {
			left.afterShow();
		}
		if (right != null) {
			right.afterShow();
		}
		System.out.println(data);
	}

	public TreeNode frontSearch(int data) {
		TreeNode node = null;
		if (this.data == data) {
			node = this;
		} else {
			if (left != null) {
				node = left.frontSearch(data);
			}
			if (node != null) {
				return node;
			}
			if (right != null) {
				node = right.frontSearch(data);
			}
		}
		return node;
	}

	public void delete(int i) {
		if (left != null && left.data == i) {
			left = null;
			return;
		}
		if (right != null && right.data == i) {
			right = null;
			return;
		}
		if (left != null) {
			left.delete(i);
		}

		if (right != null) {
			right.delete(i);
		}
	}

}
