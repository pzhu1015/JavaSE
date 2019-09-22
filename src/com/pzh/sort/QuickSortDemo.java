/**
* @Author pzh
* @Date 2019��9��20�� ����11:24:42
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
			// �������еĵ�0��������Ϊ��׼��
			int mid = array[start];
			// ��¼��Ҫ������±�
			int low = start;
			int high = end;
			// ѭ���ұȱ�׼������ͱȱ�׼С����
			while (low < high) {
				// �ұߵ����ֱȱ�׼����
				while (low < high && array[high] >= mid) {
					high--;
				}
				// ʹ���ұߵ������滻��ߵ���
				array[low] = array[high];

				// ��� ��ߵ����ֱȱ�׼��С
				while (low < high && array[low] <= mid) {
					low++;
				}
				array[high] = array[low];
			}
			// �˴�low��high��ȣ���low, highһ��
			// �ѱ�׼������������λ�õ�Ԫ��
			array[low] = mid;

			// ������ߵ���(�������Ѿ��ȱ�׼��С)
			quickSort(array, start, low);
			// �����ұߵ���(�������Ѿ��ȱ�׼����
			quickSort(array, low + 1, end);

		}
	}
}
