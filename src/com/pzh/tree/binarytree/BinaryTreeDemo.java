/**
* @Author pzh
* @Date 2019年9月25日 下午7:42:09
* @Description 
*/
package com.pzh.tree.binarytree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		TreeNode root = new TreeNode(1);
		tree.setRoot(root);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));

		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));

		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));

		tree.beforeShow();
		System.out.println("=====================");
		tree.midShow();
		System.out.println("=====================");
		tree.afterShow();
		System.out.println("=====================");

		TreeNode node = tree.frontSearch(5);
		System.out.println(node);
		
		System.out.println("=====================");
		
		tree.delete(5);
		tree.beforeShow();
	}

}
