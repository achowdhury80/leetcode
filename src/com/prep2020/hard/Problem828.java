package com.prep2020.hard;
import java.util.*;
public class Problem828 {
	public int uniqueLetterString(String s) {
		int n = s.length();
		List<Integer>[] loc = new List[26];
		for (int i = 0; i < 26; i++) loc[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	int idx = s.charAt(i) - 'A';
        	loc[idx].add(i);
        }
        int result = 0;
        for (int i = 0;i < 26; i++) {
        	if (!loc[i].isEmpty()) {
        		result += count(loc[i], n);
        	}
        }
        return result;
    }

	private int count(List<Integer> list, int n) {
		int left =-1, result = 0;
		for (int i = 0; i < list.size(); i++) {
			int leftCount = list.get(i) - left;
			int rightCount = n - list.get(i);
			if (i < list.size() - 1) rightCount = list.get(i + 1) - list.get(i);
			result += leftCount * rightCount;
			left = list.get(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem828 problem = new Problem828();
		System.out.println(problem.uniqueLetterString("ABC"));
	}
}
