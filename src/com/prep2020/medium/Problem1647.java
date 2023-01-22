package com.prep2020.medium;
import java.util.*;
public class Problem1647 {
	public int minDeletions(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i : arr) {
        	int deletes = 0;
        	while(i > 0 && set.contains(i)) {
        		i--;
        		deletes++;
        	}
        	if (i > 0) set.add(i);
        	result += deletes;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1647 problem = new Problem1647();
		System.out.println(problem.minDeletions("ceabaacb"));
	}
}
