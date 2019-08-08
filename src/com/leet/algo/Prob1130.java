package com.leet.algo;
import java.util.*;
public class Prob1130 {
	
	/**
	 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
	 * @param arr
	 * @return
	 */
	public int mctFromLeafValues(int[] arr) {
        int result = 0;
        Stack<Integer> s = new Stack<>();
        s.push(Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
        	if (s.peek() <= arr[i]) {
        		int mid = s.pop();
        		result += mid * Math.min(s.peek(), arr[i]);
        	}
        	s.push(arr[i]);
        }
        while (s.size() > 2) {
        	result += s.pop() * s.peek();
        }
        return result;
    }
}
