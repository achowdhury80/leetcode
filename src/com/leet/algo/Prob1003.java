package com.leet.algo;
import java.util.*;
public class Prob1003 {
	public boolean isValid(String S) {
		Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
        	if (stack.size() > 1 && c == 'c' && stack.peek() == 'b') {
        		stack.pop();
        		if (stack.peek() == 'a') stack.pop();
        		else {
        			stack.push('b');
        			stack.push(c);
        		}
        	} else stack.push(c);
        }
        return stack.isEmpty();
    }
}
