/**
* @Author pzh
* @Date 2019年10月21日 下午10:27:00
* @Description 
*/
package com.pzh.tree.binarysorttree;

import javax.naming.directory.SearchControls;

public class BinarySortTree {
	private Node root;
	
	public BinarySortTree(Node root) {
		this.root = root;
	}
	
	public BinarySortTree() {
		// TODO Auto-generated constructor stub
	}

	public void add(Node node) {
		if (root == null) {
			root = node;
		}else {
			root.add(node);
		}
	}
	
	public void midShow() {
		if (root != null) {
			root.midShow(root);
		}
	}
	
	public Node search(int value) {
		if (root != null) {
			return root.search(value);
		}
		return null;
	}
	
	public void delete(int value) {
		if (root == null) {
			return;
		}else {
			//找到这个节点
			Node target = search(value);
			if (target == null) {
				return;
			}
			//找到他的父亲节点
			Node parent = searchParent(value);
			//要删除的节点是叶子节点
			if (target.getLeft() == null && target.getRight() == null) {
				if (parent.getLeft().getValue() == value) {
					parent.setLeft(null);
				}else {
					parent.setRight(null);
				}
			//要删除的节点有两个子节点的情况
			}else if (target.getLeft() != null && target.getRight() != null) {
				
			//要删除的节点有一个左子节点或右子节点
			}else {
				//有左子节点
				if (target.getLeft() != null) {
					if (parent.getLeft().getValue() == value) {
						parent.setLeft(target.getLeft());
					}else {
						parent.setRight(target.getLeft());;
					}
				//有右子节点
				}else {	
					if (parent.getLeft().getValue() == value) {
						parent.setLeft(target.getRight());
					}else {
						parent.setRight(target.getRight());;
					}
				}
			}
		}
	}
	
	public Node searchParent(int value) {
		if (root == null) {
			return null;
		}else {
			return root.searchParent(value);
		}
	}
}
