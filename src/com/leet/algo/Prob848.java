package com.leet.algo;

public class Prob848 {
	public String shiftingLetters(String S, int[] shifts) {
        int[] rightSum = new int[shifts.length];
        rightSum[shifts.length - 1] = shifts[shifts.length - 1];
        for (int i = shifts.length - 2; i > -1; i--) {
        	rightSum[i]  = (shifts[i] + rightSum[i + 1]) % 26;
        }
        char[] arr = S.toCharArray();
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
        	result[i] = (char)((((arr[i] - 'a') + rightSum[i])) % 26 + 'a');
        }
        return new String(result);
    }
}
