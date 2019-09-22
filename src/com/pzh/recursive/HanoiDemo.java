/**
* @Author pzh
* @Date 2019��9��20�� ����9:46:09
* @Description 
*/
package com.pzh.recursive;

public class HanoiDemo {

	public static void main(String[] args) {
		hanoi(5, 'A', 'B', 'C');
	}

	public static void hanoi(int n, char from, char in, char to) {
		if (n == 1) {
			System.out.println("��1�����Ӵ�" + from + "�Ƶ�" + to);
		} else {
			hanoi(n - 1, from, to, in);
			System.out.println("��" + n + "�����Ӵ�" + from + "�Ƶ�" + to);
			hanoi(n - 1, in, from, to);
		}
	}
}
