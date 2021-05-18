package br.com.elton.queues;

import java.util.NoSuchElementException;

import br.com.elton.models.Employee;

public class ArrayQueue {

	private Employee[] queue;
	private int front;
	private int back;

	
	
	public ArrayQueue(int capacity) {
		queue = new Employee[capacity];
	}
	
	public void add(Employee employee) {
		if(back == queue.length) {
			Employee[] tempQueue = new Employee[queue.length * 2];
			System.arraycopy(queue, 0, tempQueue, 0, queue.length);
			queue = tempQueue;
		}
		
		//add employee in back index and then increment
		queue[back++] = employee;
	}
	
	public Employee peek() {
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		
		return queue[front];
	}
	
	
	public Employee remove() {
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		
		Employee employee = queue[front];
		//assign null to front and then increment front
		queue[front++] = null;
		
		if(size() == 0) {
			front = 0;
			back = 0;
		}
		
		return employee;
		
	}

	public int size() {
		return back - front;
	}
	
	public void printQueue() {
		for (int i = front; i < back; i++) {
			System.out.println(queue[i]);
		}
	}
	
}

