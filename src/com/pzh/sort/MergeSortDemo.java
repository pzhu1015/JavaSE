/**
* @Author pzh
* @Date 2019年9月22日 下午8:22:54
* @Description 
*/
package com.pzh.sort;

import java.util.Arrays;

public class MergeSortDemo {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 5, 1, 4, 6, 9, 11, 33, 44, 7, 99, 56, 78, 100 };
		System.out.println(Arrays.toString(array));
		mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	private static void mergeSort(int[] array, int low, int high) {

		if (low < high) {
			int mid = (high + low) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}

	public static void merge(int array[], int low, int mid, int high) {
		// 用于存储归并后的临时数组
		int[] merge_array = new int[high - low + 1];
		// 记录第一个数组中需要遍历的下标
		int i = low;
		// 记录第二个数组中需要遍历的下标
		int j = mid + 1;
		// 用于记录在临时数组中存放的下标
		int index = 0;
		while (i <= mid && j <= high) {
			// 第一个数组的数据更小
			if (array[i] <= array[j]) {
				// 所小的数据放入临时数组中
				merge_array[index] = array[i];
				// 让下标向后移一位
				i++;
			} else {
				merge_array[index] = array[j];
				j++;
			}
			index++;
		}

		// 处理多余的数据
		while (j <= high) {
			merge_array[index] = array[j];
			j++;
			index++;
		}

		while (i <= mid) {
			merge_array[index] = array[i];
			i++;
			index++;
		}

		// 把临时数组中的数据重新存入原数组
		for (int k = 0; k < merge_array.length; k++) {
			array[k + low] = merge_array[k];
		}
	}
}
