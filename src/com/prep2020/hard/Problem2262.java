package com.prep2020.hard;

import java.util.*;

public class Problem2262 {
	public long appealSum(String s) {
        int n =s.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	int idx = s.charAt(i) - 'a';
        	pos[idx].add(i);
        }
        long result = 0;
        for (int i = 0; i < 26; i++) {
        	List<Integer> index = pos[i];
        	if (index.size() == 0) continue;
        	for (int j = 0; j < index.size(); j++) {
        		int leftCount = index.get(j);
        		int rightCount = (j == index.size() - 1 ? n : index.get(j + 1)) - 1 - index.get(j);
        		result += (leftCount + 1) * (rightCount + 1);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2262 problem = new Problem2262();
		System.out.println(problem.appealSum("abbca"));
	}
}
