/**
* @Author pzh
* @Date 2019年10月19日 下午10:25:15
* @Description 
*/
package com.pzh.tree.huffmantree;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] { 3, 5, 7, 8, 11, 14, 23, 29 };

		Node node = createHuffmanTree(array);
	}

	// 创赫夫曼树
	public static Node createHuffmanTree(int[] array) {
		
		// *. 先使用数组中所有的元素创过若干个二叉树
		List<Node> nodes = new ArrayList<>();
		for (int value : array) {
			nodes.add(new Node(value));
		}

		while (nodes.size() > 1) {
			// *. 排序
			Collections.sort(nodes);
//			System.out.println(nodes);
			// *. 取出来权值最小的两个二叉树
			Node left = nodes.get(nodes.size() -1);
			Node right = nodes.get(nodes.size() -2);
			// *. 创建一颗新的二叉树
			Node parent = new Node(left.getValue() + right.getValue());
			// *. 把取出来的两个二叉树移除
			nodes.remove(left);
			nodes.remove(right);
			// *. 放入原来的二叉树集合中
			nodes.add(parent);
		}
		System.out.println(nodes);
		return nodes.get(0);
	}
}
