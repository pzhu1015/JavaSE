/**
* @Author pzh
* @Date 2019年9月20日 下午11:03:15
* @Description 
*/
package com.pzh.sort;

import java.util.Arrays;

public class BubbleSortDemo {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 5, 1, 4, 6, 9 , 11, 33, 44, 7, 99, 56, 78, 100};
		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void bubbleSort(int array[]) {
		//控制共比较多少轮
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int big_value = array[j];
					array[j] = array[j + 1];
					array[j + 1] = big_value;
				}
			}
		}
	}
}
