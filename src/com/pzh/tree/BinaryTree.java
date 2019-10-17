/**
* @Author pzh
* @Date 2019年9月25日 下午7:20:40
* @Description 
*/
package com.pzh.tree;

public class BinaryTree {
	TreeNode root;

	public BinaryTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BinaryTree(TreeNode root) {
		this.root = root;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void beforeShow() {
		if (root != null) {
			this.root.beforeShow();
		}
	}

	public void midShow() {
		if (root != null) {
			this.root.midShow();
		}
	}

	public void afterShow() {
		if (root != null) {
			this.root.afterShow();
		}
	}

	public TreeNode frontSearch(int data) {
		if (root != null) {
			return this.root.frontSearch(data);
		}
		return null;
	}

	public void delete(int i) {
		if (this.root.getData() == i) {
			this.root = null;
		} else {
			this.root.delete(i);
		}
	}
}
