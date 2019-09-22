/**
* @Author pzh
* @Date 2019年9月15日 下午11:00:47
* @Description 
*/
package com.pzh.array;
public class BinarySearchDemo {

	public static void main(String[] args) {

		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		int target = 11;
		int index = -1;
		int begin = 0;
		int end = array.length - 1;
		int mid = (begin + end)/2;
		
		while(true) {
			if (begin >= end) {
				index = -1;
				break;
			}
			if (array[mid] == target) {
				index = mid;
				break;
			}else {
				if (array[mid] > target) {
					end = mid - 1;
				}else {
					begin = mid + 1;
				}
			}
			mid = (begin + end)/2;
		}
		System.out.println("binary search target index: " + index);
	}

}
