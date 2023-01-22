package com.prep2020.easy;

public class Problem1816 {
	public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        String result = "";
        for (int i = 0; i < k; i++) result += arr[i] + " ";
        return result.substring(0, result.length() - 1);
    }
}
