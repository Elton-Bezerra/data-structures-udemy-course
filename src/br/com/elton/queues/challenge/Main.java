package br.com.elton.queues.challenge;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {

    	LinkedList<Character> stack = new LinkedList<>();
    	LinkedList<Character> queue = new LinkedList<>();
    	
    	String lowerCase = string.toLowerCase();
    	
    	for (int i = 0; i < lowerCase.length(); i++) {
    		char c = lowerCase.charAt(i);
    		
    		if(c >= 'a' && c <= 'z') {
    			stack.push(c);
    			queue.addLast(c);
    		}
    	}    	
    	
    	while(!stack.isEmpty()) {
    		char stackChar = stack.pop();
    		char queueChar = queue.removeFirst();
    		
    		if(stackChar != queueChar) {
    			return false;
    		}
    	}
    	
        return true;
    }
}
