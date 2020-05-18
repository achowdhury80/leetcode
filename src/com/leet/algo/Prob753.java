package com.leet.algo;
import java.util.*;
public class Prob753 {
	/**
	 * https://leetcode.com/problems/cracking-the-safe/discuss/314906/Java-DFS-not-a-fast-solution-but-easy-to-understand.-With-explanation.
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public String crackSafe(int n, int k) {
        int total = 1;
        String res = "";
        /*
         * total variation = k^n
         * in the result string, first one use n chars, then later ones uses
         * previous n-1 char plus one new char
         * so total should be n + (k^n - 1)
         * computing total
         */
        for (int i = 0; i < n; i++) {
        	total *= k;
        	res += "0";
        }
        total += (n - 1);
        Set<String> visited = new HashSet<>();
        visited.add(res);
        return dfs(n, k, res, visited, total);
    }
	
	private String dfs(int n, int k, String res, Set<String> visited, int total) {
		int len = res.length();
		String next = res.substring(len - n + 1, len);
		for (int i = 0; i < k; i++) {
			next += i;
			if (!visited.contains(next)) {
				visited.add(next);
				String temp = dfs(n, k, res + i, visited, total);
				if (temp.length() == total) {
					res = temp;
					break;
				}
				visited.remove(next);
			}
			next = next.substring(0, n - 1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Prob753 prob = new Prob753();
		System.out.println(prob.crackSafe(2, 2));
	}
}
