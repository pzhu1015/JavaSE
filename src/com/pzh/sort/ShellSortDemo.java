/**
* @Author pzh
* @Date 2019��9��22�� ����11:10:58
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
		// �������в���
		for (int d = array.length / 2; d > 0; d /= 2) {
			// �������е�Ԫ��
			for (int i = d; i < array.length; i++) {
				// �������������е�Ԫ��
				for (int j = i - d; j >= 0; j -= d) {
					// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ��
					if (array[j] > array[j+d]) {
						int tmp = array[j];
						array[j] = array[j+d];
						array[j+d] = tmp;
					}
				}
			}
			System.out.println("��" + (++k) + "��������: " + Arrays.toString(array));
		}
	}

}
