/**
* @Author pzh
* @Date 2019年9月20日 下午11:24:42
* @Description 
*/
package com.pzh.sort;

import java.util.Arrays;

public class QuickSortDemo {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 5, 1, 4, 6, 9, 11, 33, 44, 7, 99, 56, 78, 100 };
		System.out.println(Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	public static void quickSort(int array[], int start, int end) {
		if (start < end) {
			// 把数组中的第0个数字作为标准数
			int mid = array[start];
			// 记录需要排序的下标
			int low = start;
			int high = end;
			// 循环找比标准大的数和比标准小的数
			while (low < high) {
				// 右边的数字比标准数大
				while (low < high && array[high] >= mid) {
					high--;
				}
				// 使用右边的数字替换左边的数
				array[low] = array[high];

				// 如果 左边的数字比标准数小
				while (low < high && array[low] <= mid) {
					low++;
				}
				array[high] = array[low];
			}
			// 此处low与high相等，用low, high一样
			// 把标准数赋给低所在位置的元素
			array[low] = mid;

			// 再排左边的数(所有数已经比标准数小)
			quickSort(array, start, low);
			// 再排右边的数(所有数已经比标准数大）
			quickSort(array, low + 1, end);

		}
	}
}
