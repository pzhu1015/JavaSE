/**
* @Author pzh
* @Date 2019年9月25日 下午7:42:09
* @Description 
*/
package com.pzh.tree.treadedbinarytree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		ThreadedNode root = new ThreadedNode(1);
		tree.setRoot(root);
		root.setLeftNode(new ThreadedNode(2));
		root.setRightNode(new ThreadedNode(3));

		root.getLeftNode().setLeftNode(new ThreadedNode(4));
		ThreadedNode fiveNode = new ThreadedNode(5);
		root.getLeftNode().setRightNode(fiveNode);

		root.getRightNode().setLeftNode(new ThreadedNode(6));
		root.getRightNode().setRightNode(new ThreadedNode(7));

		System.out.println("中序遍历");
		tree.midShow();
		System.out.println("==================================");
		tree.threadNodes();
		ThreadedNode afterFive = fiveNode.getRightNode();
		System.out.println(afterFive.getValue());

		System.out.println("==================================");
		tree.threadIterate();
	}

}
