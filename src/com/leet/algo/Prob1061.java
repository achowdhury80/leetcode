package com.leet.algo;
public class Prob1061 {
	public String smallestEquivalentString(String A, String B, String S) {
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        for (int i = 0; i < A.length(); i++) {
        	int p1 = find(arr, A.charAt(i) - 'a');
        	int p2 = find(arr, B.charAt(i) - 'a');
        	if (p1 != p2) {
        		arr[Math.max(p1,  p2)] = Math.min(p1,  p2);
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
        	sb.append((char)(find(arr, S.charAt(i) - 'a') + 'a'));
        }
        return sb.toString();
    }
	
	private int find(int[] arr, int i) {
		while(i != arr[i]) i = arr[i];
		return i;
	}
	
	
}
