package com.leet.algo;

public class Prob1156 {
	public int maxRepOpt1(String text) {
		int[] count = new int[26];
		char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	count[arr[i] - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i];
        	int j = i;
        	int subCount = 0;
        	boolean used = false;
        	while(j < arr.length && (arr[j] == c || !used)) {
        		subCount++;
        		if (arr[j] != c) {
        			used = true;
        			i = j - 1;
        		}
        		if (!used || subCount <= count[c - 'a'])
        			result = Math.max(result, subCount);
        		j++;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1156 prob = new Prob1156();
		System.out.println(prob.maxRepOpt1("ababa"));
		System.out.println(prob.maxRepOpt1("abcdef"));
		System.out.println(prob.maxRepOpt1("bbababaaaa"));
	}
}
