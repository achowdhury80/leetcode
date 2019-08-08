package com.leet.algo;
import java.util.*;
public class Prob1062 {
	public int longestRepeatingSubstring(String S) {
        int[] pow = new int[S.length()];
        int prod = 1;
        for (int i = 0; i < S.length(); i++) {
        	pow[i] = prod;
        	prod = prod * 26 % 10000007;
        }
        int l = 0, r = S.length() - 1;
        char[] arr = S.toCharArray();
        while(l < r) {
        	int mid = l + (r - l) / 2;
        	if (isValid(mid, arr, pow)) {
        		l = mid;
        	} else r = mid - 1;
        }
        return l;
    }
	
	private boolean isValid(int n, char[] arr, int[] pow) {
		if (n == 0) return false;
		int hash = 0, mod = 10000007, base = 26;
		for (int i = 0; i < n; i++) {
			hash = ((hash * 26) % mod + (arr[i] - 'a')) % mod;
		}
		Map<Integer, Integer> visited = new HashMap<>();
		visited.put(hash, 0);
		for (int i = n; i < arr.length; i++) {
			hash -= (arr[i - n] - 'a') * pow[n - 1] % mod;
			hash = (base * hash % mod + (arr[i] - 'a')) % mod;
			if (visited.containsKey(hash) && isMatch(arr, visited.get(hash), i - n + 1, n)) return true;
			visited.put(hash, i - n + 1);
		}
		return false;
	}
	
	private boolean isMatch(char[] arr, int i, int j, int n) {
		for (int k = 0; k < n; k++) {
			if (arr[i + k] != arr[j + k]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Prob1062 prob = new Prob1062();
		System.out.println(prob.longestRepeatingSubstring("abbaba"));
	}
}
