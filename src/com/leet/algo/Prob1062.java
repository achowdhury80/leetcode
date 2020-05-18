package com.leet.algo;
import java.util.*;
public class Prob1062 {
	public int longestRepeatingSubstring(String S) {
		int l = 1, r = S.length() - 1;
        int result = 0;
        while (l <= r) {
        	int mid = l + (r - l) / 2;
        	Set<String> set = new HashSet<>();
        	for (int i = 0; i + mid - 1 < S.length(); i++) {
        		String sub = S.substring(i, i + mid);
        		if (set.contains(sub)) {
        			result = sub.length();
        			break;
        		} else set.add(sub);
        	}
        	if (result == mid) l = mid + 1;
        	else r = mid - 1;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1062 prob = new Prob1062();
		System.out.println(prob.longestRepeatingSubstring("abbaba"));
		System.out.println(prob.longestRepeatingSubstring("abcd"));
	}
}
