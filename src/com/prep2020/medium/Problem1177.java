package com.prep2020.medium;
import java.util.*;
public class Problem1177 {
	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> result = new ArrayList<>();
		int cur = 0, n = s.length();
		int[] arr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			int idx = s.charAt(i) - 'a';
			cur ^= (1 << idx);
			arr[i + 1] = cur;
		}
		for (int i = 0; i < queries.length; i++) {
			int right = arr[queries[i][1] + 1], left = arr[queries[i][0]];
			int diff = Integer.bitCount(right ^ left);
			diff -= 2 * queries[i][2];
			if ((queries[i][1] - queries[i][0] + 1) % 2 == 1) diff--;
			result.add(diff <= 0);
		}
		return result;
    }
	
	public static void main(String[] args) {
		Problem1177 problem = new Problem1177();
		System.out.println(problem.canMakePaliQueries("abcda", new int[][] {{0, 3, 2}}));
	}
}
