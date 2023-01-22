package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2211 {
	public int countCollisions(String directions) {
        Deque<Character> stack = new ArrayDeque<>();
        int result = 0;
        for (char c : directions.toCharArray()) {
        	if (stack.isEmpty() && c == 'L') continue;
        	if (stack.isEmpty()) {
        		stack.push(c);
        		continue;
        	}
        	if (stack.peek() == 'S') {
        		if (c == 'L') result++;
        		else {
        			stack.clear();
        			stack.push(c);
        		} 
        	} else if (stack.peek() == 'R') {
        		if (c == 'R') {
        			stack.push(c);
        		} else if (c == 'S'){
        			result += 1;
        			stack.pop();
        			while (!stack.isEmpty() && stack.peek() == 'R') {
        				result++;
        				stack.pop();
        			}
        			stack.push('S');
        		} else {
        			result += 2;
        			stack.pop();
        			while (!stack.isEmpty() && stack.peek() == 'R') {
        				result++;
        				stack.pop();
        			}
        			stack.push('S');
        		}
        	}
        }
        return result;
    }
}
