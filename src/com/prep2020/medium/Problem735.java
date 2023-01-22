package com.prep2020.medium;
import java.util.*;
public class Problem735 {
	public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
        	if (a > 0) stack.push(a);
        	else {
        		while(!stack.isEmpty()) {
        			if (stack.peek() < 0) break;
        			int peek = stack.peek();
        			if (peek > -a) {
        				a = 0;
        				break;
        			} else if (peek == -a) {
        				stack.pop();
        				a = 0;
        				break;
        			} else {
        				stack.pop();
        			}
        		}
        		if (a != 0) stack.push(a);
        	}
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i > -1; i--) result[i] = stack.pop();
        return result;
    }
}
