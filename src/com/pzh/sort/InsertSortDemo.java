/**
* @Author pzh
* @Date 2019年9月22日 上午10:41:55
* @Description 
*/
package com.pzh.sort;

import java.util.Arrays;

public class InsertSortDemo {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 5, 1, 4, 6, 9 , 11, 33, 44, 7, 99, 56, 78, 100};
		System.out.println(Arrays.toString(array));
		insertSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void insertSort(int[] array) {

		//遍历所有的数字
		for (int i = 1; i < array.length; i++) {
			//如果当前数字比前一个数字小
			if (array[i] < array[i-1]) {
				//把当前遍历数字存起来
				int tmp = array[i];
				int j;
				// 遍历当前数字前面所有的数字
				for (j = i -1; j >= 0 && array[j] > tmp; j--) {
					//把前一个数字赋给后一个数字
					array[j + 1] = array[j];
				}
				//把临时变量(外层for循环的当前元素)赋给不满足条件的后一个元素
				array[j+1] = tmp;
			}
		}
	}

}
