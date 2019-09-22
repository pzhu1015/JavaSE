/**
* @Author pzh
* @Date 2019��9��22�� ����10:41:55
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

		//�������е�����
		for (int i = 1; i < array.length; i++) {
			//�����ǰ���ֱ�ǰһ������С
			if (array[i] < array[i-1]) {
				//�ѵ�ǰ�������ִ�����
				int tmp = array[i];
				int j;
				// ������ǰ����ǰ�����е�����
				for (j = i -1; j >= 0 && array[j] > tmp; j--) {
					//��ǰһ�����ָ�����һ������
					array[j + 1] = array[j];
				}
				//����ʱ����(���forѭ���ĵ�ǰԪ��)���������������ĺ�һ��Ԫ��
				array[j+1] = tmp;
			}
		}
	}

}
