package com.leet.algo;

public class Prob744 {
	public char nextGreatestLetter(char[] letters, char target) {
		int l = 0, h = letters.length - 1;
		while(l < h) {
			int mid = l + (h - l) / 2;
			if (letters[mid] > target) h = mid;
			else l = mid + 1;
		}
		if (letters[l] > target) return letters[l];
		return letters[0];
	}
}
