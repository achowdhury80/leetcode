package com.leet.algo;
import java.util.*;
public class Prob591 {
	public boolean isValid(String code) {
		char[] arr = code.toCharArray();
		int n = arr.length, i = 0;
		if (n == 0 || arr[0] != '<') return false;  //must start with a tag
		Stack<Integer> stack = new Stack<>(); //a stack recording tags
		return stack.isEmpty();
		
    }
}
