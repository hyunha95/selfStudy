package kh.java.collection.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueStackStudy {

	public static void main(String[] args) {
		QueueStackStudy study = new QueueStackStudy();
		study.queueTest();
//		study.stackTest();
		
	}

	/**
	 * Stack
	 * 
	 * LIFO Last In First Out
	 * 
	 * - push()  요소추가
	 * - pop()   요소제거
	 * - peek()  이번에 Out할 요소확인
	 * 
	 */
	private void stackTest() {
		Stack<Integer> stack = new Stack<>();
		stack.push(33);
		stack.push(22);
		stack.push(11);

//		System.out.println(stack.pop()); //꺼내면 바로 제거됨
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println(stack.size()); 
		
		
	}

	/**
	 * Queue
	 * 
	 * FIFO First In First Out
	 * 
	 * - offer 요소추가
	 * - poll  요소제거
	 * - peek  다음 Out할 요소 확인
	 * 
	 */
	private void queueTest() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(33);
		q.offer(22);
		q.offer(11);
		
		System.out.println(q.peek());
//		System.out.println(q.poll()); //꺼내면 바로 제거됨
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		System.out.println(q.size());	
	}
}
