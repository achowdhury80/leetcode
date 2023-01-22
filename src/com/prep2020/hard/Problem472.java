package com.prep2020.hard;
import java.util.*;
public class Problem472 {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Set<String> set = new HashSet<>();
		for (String w : words) set.add(w);
		List<String> result = new ArrayList<>();
		for (String w : words) {
			set.remove(w);
			if (isAvailable(w, set)) result.add(w);
			set.add(w);
		}
		return result;
    }
	
	private boolean isAvailable(String str, Set<String> set) {
		int n = str.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 0; i <= n; i++) {
			if (!dp[i]) continue;
			for (int j = i + 1; j <= n; j++) {
				if (set.contains(str.substring(i, j))) dp[j] = true;
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Problem472 problem = new Problem472();
		System.out.println(problem.findAllConcatenatedWordsInADict(new String[] {"cat", "dog", "catdog"}));
	}
}
