/**
* @Author pzh
* @Date 2019年10月19日 下午1:33:44
* @Description 
*/
package com.pzh.tree.treadedbinarytree;

public class ThreadedBinaryTree {
	private ThreadedNode root;

	private ThreadedNode prev;

	public ThreadedNode getRoot() {
		return root;
	}

	public void setRoot(ThreadedNode root) {
		this.root = root;
	}

	public ThreadedNode getPrev() {
		return prev;
	}

	public void setPrev(ThreadedNode prev) {
		this.prev = prev;
	}

	public void beforeShow() {
		if (root != null) {
			root.beforeShow();
		}
	}

	public void midShow() {
		if (root != null) {
			root.midShow();
		}
	}

	public void afterShow() {
		if (root != null) {
			root.afterShow();
		}
	}

	// 中序线索化二叉树
	public void threadNodes() {
		threadNodes(root);
	}

	// 中序线索化二叉树
	public void threadNodes(ThreadedNode node) {

		if (node == null) {
			return;
		}
		// 处理左子树
		threadNodes(node.getLeftNode());

		// 处理前驱节点
		if (node.getLeftNode() == null) {
			// 让当前节点的左指针指向前驱节点
			node.setLeftNode(prev);
			// 改变当前节点左指针的类型
			node.setLeftType(1);
		}

		// 处理前驱节点的右指针， 如果前驱节点的右指针是null
		if (prev != null && prev.getRightNode() == null) {
			// 让前驱节点的右指针指向当前节点
			prev.setRightNode(node);
			// 改变前驱节点的右指针类型
			prev.setRightType(1);
		}

		// 每处理一个节点，当前节点是下一个节点的前驱节点
		prev = node;

		// 处理右子树
		threadNodes(node.getRightNode());
	}

	public void threadIterate() {
		// 用于临时存储当前遍历的节点
		ThreadedNode node = root;
		while (node != null) {
			// 循环找到最开始的节点
			while (node.getLeftType() == 0) {
				node = node.getLeftNode();
			}
			// 打印当前节点的值
			System.out.println(node.getValue());
			// 如果当前节点的右指针指向的是后继节点，可能后继节点还有后继七点
			while (node.getRightType() == 1) {
				node = node.getRightNode();
				System.out.println(node.getValue());
			}
			// 替换遍历的节点
			node = node.getRightNode();
		}
	}
}
