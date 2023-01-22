package com.prep2020.hard;

import java.util.Arrays;

public class Problem1255 {
	/**
	 * O(2^n)
	 * where n is number of words
	 * @param words
	 * @param letters
	 * @param score
	 * @return
	 */
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] counts = new int[26];
        for (char c : letters) counts[c - 'a']++;
        int[] wScores = new int[words.length];
        for (int i = 0; i < words.length; i++) {
        	int sum = 0;
        	for (char c : words[i].toCharArray()) sum += score[c - 'a'];
        	wScores[i] = sum;
        }
        int[] result = new int[] {0};
        helper(counts, wScores, words, 0, 0, result);
        return result[0];
    }
	
	private void helper(int[] counts, int[] wScores, String[] words, int start, int curScore, int[] result) {
		result[0] = Math.max(result[0], curScore);
		for (int i = start; i < words.length; i++) {
			int[] newCounts = findNewCountAfterTakingWord(words[i], counts);
			if (newCounts != null) {
				helper(newCounts, wScores, words, i + 1, curScore + wScores[i], result);
			}
		}
	}
	
	private int[] findNewCountAfterTakingWord(String w, int[] counts) {
		int[] newCount = Arrays.copyOf(counts, counts.length);
		for (char c : w.toCharArray()) {
			if (newCount[c - 'a'] == 0) return null;
			newCount[c - 'a']--;
		}
		return newCount;
	}
}
