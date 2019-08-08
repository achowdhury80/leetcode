package com.leet.algo;
public class Prob1100 {
	public int numKLenSubstrNoRepeats(String S, int K) {
        char[] arr = S.toCharArray();
        if (arr.length < K) return 0;
        int[] charMap = new int[26];
        int result = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
        	int newChar = arr[i] - 'a';
        	charMap[newChar]++;
        	if (charMap[newChar] < 2) count++;
        	if (i - K > - 1) {
        		int oldChar = arr[i - K] - 'a';
        		charMap[oldChar]--;
        		if (charMap[oldChar] == 0) count--;
        	}
        	if(count == K) result++;
        }
        return result;
    }
}
