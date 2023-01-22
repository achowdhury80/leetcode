package com.prep2020.medium;

public class Problem848 {
	public String shiftingLetters(String s, int[] shifts) {
        for (int i = shifts.length - 2; i > -1; i--) 
        	shifts[i] += (shifts[i + 1] % 26);
        char[] arr = s.toCharArray();
        for (int i = 0; i < shifts.length; i++) {
        	arr[i] = (char)(((arr[i] - 'a') + shifts[i]) % 26 + 'a');
        }
        return new String(arr);
    }
}
