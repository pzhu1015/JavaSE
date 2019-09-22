/**
* @Author pzh
* @Date 2019年9月20日 下午9:46:09
* @Description 
*/
package com.pzh.recursive;

public class HanoiDemo {

	public static void main(String[] args) {
		hanoi(5, 'A', 'B', 'C');
	}

	public static void hanoi(int n, char from, char in, char to) {
		if (n == 1) {
			System.out.println("第1个盘子从" + from + "移到" + to);
		} else {
			hanoi(n - 1, from, to, in);
			System.out.println("第" + n + "个盘子从" + from + "移到" + to);
			hanoi(n - 1, in, from, to);
		}
	}
}
