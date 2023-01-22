package com.prep2020.hard;
import java.util.*;
public class Problem1220 {
	public int countVowelPermutation(int n) {
		String vowels = "aeiou";
		int l = vowels.length();
		long mod = (long)(1e9 + 7);
		long[] dp = new long[l];
		Map<Character, String> nextMap = new HashMap<>();
		nextMap.put('a', "e");
		nextMap.put('e', "ai");
		nextMap.put('i', "aeou");
		nextMap.put('o', "iu");
		nextMap.put('u', "a");
		for (int i = 0; i < l; i++) dp[i] = 1l;
		for (int i = 2; i <= n; i++) {
			long[] temp = new long[l];
			for (int j = 0; j < l; j++) {
				String nextChars = nextMap.get(vowels.charAt(j));
				for (char c : nextChars.toCharArray()) {
					int idx = vowels.indexOf(c);
					temp[idx] = (temp[idx] + dp[j]) % mod;
				}
			}
			dp = temp;
		}
		long sum = 0l;
		for (long a : dp) {
			sum = (sum + a) % mod;
		}
		return (int)sum;
    }
}
