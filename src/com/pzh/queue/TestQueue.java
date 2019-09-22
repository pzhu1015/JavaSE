/**
* @Author pzh
* @Date 2019年9月17日 下午10:28:05
* @Description 
*/
package com.pzh.queue;

public class TestQueue {

	public static void main(String[] args) {

		LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.offer(10);
		queue.offer(11);
		queue.offer(12);
		queue.offer(13);
		queue.offer(14);
		System.out.println(queue);
		
		Integer e = null;
		while((e = queue.poll()) != null) {
			System.out.println(e);
			System.out.println(queue);
		}
	}

}
