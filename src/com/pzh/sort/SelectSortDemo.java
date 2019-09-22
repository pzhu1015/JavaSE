/**
* @Author pzh
* @Date 2019年9月22日 下午5:36:55
* @Description 
*/
package com.pzh.sort;

import java.util.Arrays;

public class SelectSortDemo {

	public static void main(String[] args) {
		
		int[] array = new int[] { 3, 5, 1, 4, 6, 9 , 11, 33, 44, 7, 99, 56, 78, 100};
		System.out.println(Arrays.toString(array));
		selectSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void selectSort(int[] array) {
		
		// 遍历所有的数
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			//把当前遍历的数和后面所有的数依次进行比较，并记录下最小的数的下标
			for (int j = i + 1; j < array.length; j++) {
				// 如果后面比较的数比记录的最小的数小
				if (array[minIndex] > array[j]) {
					// 记录下最小的那个数的下标
					minIndex = j;
				}
			}
			//如果最小的数和当前遍历数的下标不一致, 说明下标为minIndex的数比当前遍历的数更小
			if (i != minIndex) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}

}
