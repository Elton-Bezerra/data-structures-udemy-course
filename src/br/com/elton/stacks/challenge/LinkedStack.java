package br.com.elton.stacks.challenge;

import java.util.LinkedList;

public class LinkedStack {

	private LinkedList<Character> stack = new LinkedList<>();
	
	public void push(Character c) {
		stack.push(c);
	}
	
	public Character pop() {
		return stack.pop();
	}
	
	public Character peek() {
		return stack.peek();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
}
