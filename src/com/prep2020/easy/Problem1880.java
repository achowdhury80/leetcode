package com.prep2020.easy;

public class Problem1880 {
	public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return findVal(firstWord) + findVal(secondWord) == findVal(targetWord);
    }
	
	private int findVal(String w) {
		int result = 0;
		int mult = 1;
		for (int i = w.length() - 1; i > -1; i--) {
			int val = w.charAt(i) - 'a';
			result += val * mult;
			mult *= 10;
		}
		return result;
	}
}
