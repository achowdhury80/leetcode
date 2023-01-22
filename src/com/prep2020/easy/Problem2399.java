package com.prep2020.easy;

public class Problem2399 {
	public boolean checkDistances(String s, int[] distance) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) arr[i] = -1;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	int idx = c - 'a';
        	if (arr[idx] == -1) arr[idx] = i;
        	else {
        		if (distance[idx] != i - arr[idx] - 1) return false;
        	}
        }
        return true;
    }
}
