package com.prep2020.medium;
import java.util.*;
public class Problem916 {
	public List<String> wordSubsets(String[] A, String[] B) {
        int[] bFreq = computeCharFreq(B[0]);
        for (int i = 1; i < B.length; i++) {
        	int[] freq = computeCharFreq(B[i]);
        	for (int j = 0; j < 26; j++) {
        		bFreq[j] = Math.max(bFreq[j], freq[j]);
        	}
        }
        List<String> result = new ArrayList<>();
        for (String a : A) {
        	int[] aFreq = computeCharFreq(a);
        	if (isCovered(aFreq, bFreq)) result.add(a);
        }
        return result;
    }
	
	private int[] computeCharFreq(String w) {
		int[] arr = new int[26];
    	for (char c : w.toCharArray()) {
    		arr[c - 'a']++;
    	}
    	return arr;
	}
	
	private boolean isCovered(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			if (a[i] < b[i]) return false;
		}
		return true;
	}
}
