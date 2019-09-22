/**
* @Author pzh
* @Date 2019年9月22日 上午11:10:58
* @Description 
*/
package com.pzh.sort;

import java.util.Arrays;

public class ShellSortDemo {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 5, 1, 4, 6, 9, 11, 33, 44, 7, 99, 56, 78, 100 };
		System.out.println(Arrays.toString(array));
		shellSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void shellSort(int[] array) {

		int k = 0;
		// 遍历所有步长
		for (int d = array.length / 2; d > 0; d /= 2) {
			// 遍历所有的元素
			for (int i = d; i < array.length; i++) {
				// 遍历本组中所有的元素
				for (int j = i - d; j >= 0; j -= d) {
					// 如果当前元素大于加上步长后的那个元素
					if (array[j] > array[j+d]) {
						int tmp = array[j];
						array[j] = array[j+d];
						array[j+d] = tmp;
					}
				}
			}
			System.out.println("第" + (++k) + "次排序结果: " + Arrays.toString(array));
		}
	}

}
