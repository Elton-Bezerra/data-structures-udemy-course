package br.com.elton.stacks.challenge;

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
    	/*
    	 * Find the length of the string say len. Now, find the mid as mid = len / 2.
			Push all the elements till mid into the stack i.e. str[0…mid-1].
			If the length of the string is odd then neglect the middle character.
			Till the end of the string, keep popping elements from the stack and compare them with the current character i.e. string[i].
			If there is a mismatch then the string is not a palindrome. If all the elements match then the string is a palindrome.
    	 */
    	
    	string = tratarString(string);

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

	private static String tratarString(String s) {		
		return s.replaceAll("\\W+", "").toLowerCase();
	}
}
