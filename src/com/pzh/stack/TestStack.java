/**
* @Author pzh
* @Date 2019年9月16日 下午11:29:10
* @Description 
*/
package com.pzh.stack;
public class TestStack {

	public static void main(String[] args) {
		
		LinkedStack<Integer> stack = new LinkedStack<>();
		
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.push(14);
		System.out.println(stack);
		
		Integer e = null;
		while((e = stack.pop()) != null) {
			System.out.println(e);
			System.out.println(stack);
		}

	}

}
