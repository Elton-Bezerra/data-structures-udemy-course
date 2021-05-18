package br.com.elton.stacks.challenge;

import java.util.LinkedList;

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
        
        System.out.println("==================================");
        
        // should return true
        System.out.println(checkForPalindromeAnswer("abccba"));
        // should return true
        System.out.println(checkForPalindromeAnswer("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindromeAnswer("I did, did I?"));
        // should return false
        System.out.println(checkForPalindromeAnswer("hello"));
        // should return true
        System.out.println(checkForPalindromeAnswer("Don't nod"));
    }
    
    public static boolean checkForPalindromeAnswer(String string) {
    	LinkedList<Character> stack = new LinkedList<>();
    	StringBuilder stringNoPonctuation = new StringBuilder(string.length());
    	String lowerCase = string.toLowerCase();
    	
    	for (int i = 0; i < lowerCase.length(); i++) {
    		char c = lowerCase.charAt(i);
    		
    		if(c >= 'a' && c <= 'z') {
    			stringNoPonctuation.append(c);
    			stack.push(c);
    		}
    	}
    	
    	StringBuilder reversedString = new StringBuilder(stack.size());
    	while(!stack.isEmpty()) {
    		reversedString.append(stack.pop());
    	}
    	
    	return stringNoPonctuation.toString().equals(reversedString.toString());
    	
    }
    
    public static boolean checkForPalindrome(String string) {
    	/*
    	 * Find the length of the string say len. Now, find the mid as mid = len / 2.
			Push all the elements till mid into the stack i.e. str[0…mid-1].
			If the length of the string is odd then neglect the middle character.
			Till the end of the string, keep popping elements from the stack and compare them with the current character i.e. string[i].
			If there is a mismatch then the string is not a palindrome. If all the elements match then the string is a palindrome.
    	 */
    	
    	string = string.toLowerCase().replaceAll("\\W+", "");

    	LinkedStack stack = new LinkedStack();
    	
    	
    	int len = string.length();
    	
    	int mid = len/2;
    	
    	int i;
    	for(i = 0; i < mid; i++) {    		
    		stack.push(Character.valueOf(string.charAt(i)));
    	}
    	
    	char ele = 0;
    	if (len % 2 != 0) {
    		i++;
    	}
    	
    	while (i < string.length()) {
    		ele = stack.peek();
    		stack.pop();
    		
    		if(ele != string.charAt(i)) {
        		return false;
        	}
    		i++;
    	}
        return true;
    }
}
