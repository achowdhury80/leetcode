package com.leet.algo;
import java.util.*;
public class Prob1047 {
	public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
        	if (s.isEmpty() || s.peek() != arr[i]) s.push(arr[i]);
        	else s.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) sb.insert(0, s.pop());
        return sb.toString();
    }
	
	
}
