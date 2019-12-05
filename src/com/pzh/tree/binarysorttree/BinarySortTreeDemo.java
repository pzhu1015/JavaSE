/**
* @Author pzh
* @Date 2019年10月21日 下午10:25:28
* @Description 
*/
package com.pzh.tree.binarysorttree;
public class BinarySortTreeDemo {

	public static void main(String[] args) {
		
		int[] array = new int[] {7, 3, 10, 12, 5, 1, 9};
		BinarySortTree tree = new BinarySortTree();
		
		for (int i : array) {
			Node node = new Node(i);
			tree.add(node);
		}
		
		tree.midShow();
//		Node node = tree.search(5);
//		System.out.println("============");
//		System.out.println(node.getValue());
//		System.out.println("=======");
//		Node p1 = tree.searchParent(1);
//		System.out.println(p1.getValue());
		System.out.println("===================");
		//删除叶子节点
		tree.delete(5);
		tree.midShow();
		System.out.println("====================");
		//删除只有一个子节点的节点
		tree.delete(3);
		tree.midShow();
	}

}
