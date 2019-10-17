/**
* @Author pzh
* @Date 2019年10月17日 下午9:25:03
* @Description 
*/
package com.pzh.tree;

public class ArrayBinaryTree {
	private int[] data;

	public ArrayBinaryTree(int[] data) {
		this.data = data;
	}
	
	public void frontShow() {
		frontShow(0);
	}

	//前序遍历
	public void frontShow(int index) {
		if (data == null || data.length == 0) {
			return;
		}
		// 先遍历当前节点的内容
		System.out.println(data[index]);
		// 2*index + 1
		if (2 * index + 1 < data.length) {
			frontShow(2 * index + 1);
		}
		// 2*index + 2
		if (2 * index + 2 < data.length) {
			frontShow(2 * index + 2);
		}
	}
}
