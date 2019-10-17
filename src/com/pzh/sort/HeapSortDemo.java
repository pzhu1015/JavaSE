/**
* @Author pzh
* @Date 2019年10月17日 下午9:49:39
* @Description 
*/
package com.pzh.sort;

import java.util.Arrays;

public class HeapSortDemo {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 5, 1, 4, 6, 9, 11, 33, 44, 7, 99, 56, 78, 100 };
		System.out.println(Arrays.toString(array));
		heapSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void heapSort(int array[]) {
		// 开始位置是最后一个非叶子节点，即最后一个节点的父节点
		int start = (array.length - 1) / 2;
		// 调整为大顶堆
		for (int i = start; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
		//先把数组中的第0个和堆中的最后一个数交换位置，再把前面的处理成大顶堆
		for (int i = array.length - 1; i > 0; i--) {
			int tmp = array[0];
			array[0] = array[i];
			array[i] = tmp;
			maxHeap(array, i, 0);
		}
	}

	public static void maxHeap(int array[], int size, int index) {
		// 左子节点
		int leftNode = 2 * index + 1;
		// 右子节点
		int rightNode = 2 * index + 2;
		int max = index;
		// 和两个节点分别对比， 找出最大的节点
		if (leftNode < size && array[leftNode] > array[max]) {
			max = leftNode;
		}
		if (rightNode < size && array[rightNode] > array[max]) {
			max = rightNode;
		}
		// 交换位置
		if (max != index) {
			int tmp = array[index];
			array[index] = array[max];
			array[max] = tmp;
			maxHeap(array, size, max);
		}
	}
}
