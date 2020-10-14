package comp.prep2019.less2000;

import java.util.Arrays;

public class Prob1255 {
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] counts = new int[26];
        for (char c : letters) counts[c - 'a']++;
        int[] wScore = new int[words.length];
        for (int i = 0; i < words.length; i++) {
        	char[] arr = words[i].toCharArray();
        	int sum = 0;
        	for (char c : arr) sum += score[c - 'a'];
        	wScore[i] = sum;
        }
        int[] result = new int[] {0};
        helper(words, 0, counts, 0, wScore, result);
        return result[0];
    }
	
	private void helper(String[] words, int start, int[] counts, int curScore, 
			int[] wScore, int[] result) {
		result[0] = Math.max(result[0], curScore);
		for (int i = start; i < words.length; i++) {
			int[] newCounts = Arrays.copyOf(counts, counts.length);
			char[] arr = words[i].toCharArray();
			boolean flag = true;
			for (char c : arr) {
				int idx = c - 'a';
				if (newCounts[idx] == 0) {
					flag = false;
					break;
				}
				newCounts[idx]--;
			}
			if (!flag) continue;
			helper(words, i + 1, newCounts, curScore + wScore[i], wScore, result);
		}
	}
}
