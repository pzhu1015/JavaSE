/**
* @Author pzh
* @Date 2019年9月22日 下午10:32:49
* @Description 
*/
package com.pzh.sort;

import java.util.Arrays;

public class RadixSortDemo {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 5, 1, 4, 6, 9, 11, 33, 44, 7, 99, 56, 78, 100 };
		System.out.println(Arrays.toString(array));
		radixSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void radixSort(int[] array) {

		// 存数组中最大的数字
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		// 计算最大数字是几位数
		int maxLength = (max + "").length();
		// 用于存储临时数据的数组
		int[][] bucket = new int[10][array.length];
		// 用于记录在bucket中相应的数组中存放的数字的数量
		int[] counts = new int[10];
		// 根据最大长度的数决定比较的次数
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			// 把每一个数字分别计算余数
			for (int j = 0; j < array.length; j++) {
				// 计算余数
				int ys = array[j] / n % 10;
				// 把当前遍历的数据放入指字的数组中
				bucket[ys][counts[ys]] = array[j];
				// 记录数量
				counts[ys]++;
			}

			// 循环取出元素
			for (int c = 0, j = 0; c < counts.length; c++) {
				for (int k = 0; k < counts[c]; k++, j++) {
					// 取出元素放入数组
					array[j] = bucket[c][k];
				}
				// 把数量置为0
				counts[c] = 0;
			}
		}
	}
}
