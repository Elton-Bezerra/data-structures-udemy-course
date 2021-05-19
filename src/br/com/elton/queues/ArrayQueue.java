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
		if(size()  == queue.length - 1) {
			int numItems = size();			
			Employee[] tempQueue = new Employee[queue.length * 2];
			
			System.arraycopy(queue, front, tempQueue, 0, queue.length - front);
			System.arraycopy(queue, 0, tempQueue, queue.length - front, back);
			
			// A cópia acima copia a partir de front até o fim do array
			// e depois copia do começo do array até a próxima posição disponível (back), reordenando o array para ficar bonitinho conforme abaixo
			// 0 jane
			// 1 john 
			// 2      - back
			// 3 mike - front
			// 4 bill
			
			// 0 mike - front
			// 1 bill 
			// 2 jane
			// 3 john
			// 4 - back
			// 5 
			// 9 
			
			queue = tempQueue;
			front = 0;
			back = numItems;
		}
		
		//add employee in back index and then increment
		queue[back] = employee;
		if(back < queue.length - 1) {
			back++;
		} else {
			back = 0;
		}
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
		} else if (front == queue.length) {
			front = 0;
		}
		
		return employee;
		
	}

	public int size() {
		if (front <= back) {
			return back - front;
		} else {
			return back - front + queue.length;
		}
		
	}
	
	public void printQueue() {
		if(front <= back) {
			for (int i = front; i < back; i++) {
				System.out.println(queue[i]);
			}
		} else {
			
			for(int i = front; i < queue.length; i++) {
				System.out.println(queue[i]);
			}
			
			for(int i = 0; i < back; i++) {
				System.out.println(queue[i]);
			}
		}
		
	}
	
}

