package com.leet.algo;

public class Prob1081 {
	public String smallestSubsequence(String text) {
        char[] arr = text.toCharArray();
        int n = arr.length;
        int[] freq = new int[26];
        for (char c : arr) freq[c - 'a']++;
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i];
        	if (used[c - 'a']) {
        		freq[c - 'a']--;
        		continue;
        	}
        	char ch;
        	int last = sb.length() - 1;
        	while (sb.length() > 0 && (ch = sb.charAt(last)) > c && freq[ch - 'a'] > 0) {
        		used[ch - 'a'] = false;
        		sb.deleteCharAt(last);
        		last--;
        	}
        	used[c - 'a'] = true;
        	freq[c - 'a']--;
        	sb.append(c);
        }
        return sb.toString();
    }
}
