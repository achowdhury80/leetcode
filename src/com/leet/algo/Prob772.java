package com.leet.algo;
import java.util.*;
public class Prob772 {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (Character.isDigit(c)) num = num * 10 + (c - '0');
        	else if (c == '(') {
        		int j = i + 1, braces = 1;
        		for (; braces > 0; j++) {
        			if (s.charAt(j) == '(') ++braces;
        			else if (s.charAt(j) == ')') --braces;
        		}
        		num = calculate(s.substring(i + 1, j - 1));
        		i = j - 1;
        		
        	} 
        	if (c == '*' || c =='/' || c == '+' || c == '-' || i == s.length() - 1) {
        		switch (sign) {
        			case '+':
        				stack.push(num);
        				break;
        			case '-':
        				stack.push(-num);
        				break;
        			case '*':
        				stack.push(stack.pop() * num);
        				break;
        			case '/':
        				stack.push(stack.pop() / num);
        				break;
        			
        		}
        		sign = c;
        		num = 0;
        	} 
        }
        int result = 0;
        while(!stack.isEmpty()) result += stack.pop();
        return result;
    }
}
