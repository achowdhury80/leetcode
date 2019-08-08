package com.leet.algo;
import java.util.*;
public class Prob946 {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < popped.length) {
        	while (stack.isEmpty() || stack.peek() != popped[i]) {
        		if (j >= pushed.length) {
        			return false;
        		}
        		stack.push(pushed[j++]);
        	}
        	if (stack.isEmpty() || stack.peek() != popped[i]) return false;
        	stack.pop();
        	i++;
        }
        return true;
    }
}
