package com.leet.algo;
import java.util.*;
public class Prob1021 {
	public String removeOuterParentheses(String S) {
		if (S == null) return S;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
        	if (c == '(') {
        		if (!stack.isEmpty()) sb.append(c);
        		stack.push(c);
        	}
        	if (c == ')') {
        		stack.pop();
        		if (!stack.isEmpty()) sb.append(c);
        	}
        }
        return sb.toString();
    }
}
