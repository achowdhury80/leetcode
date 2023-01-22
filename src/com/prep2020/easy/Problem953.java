package com.prep2020.easy;

public class Problem953 {
	/**
	 * O(NW)
	 * @param words
	 * @param order
	 * @return
	 */
	public boolean isAlienSorted(String[] words, String order) {
        int[] arr = new int[26];
        for (int i = 0; i < order.length(); i++) arr[order.charAt(i) - 'a'] = i;
        for (int i = 0; i < words.length - 1; i++) {
        	if (!isSorted(words[i], words[i + 1], arr)) return false;
        }
        return true;
    }
	
	private boolean isSorted(String w1, String w2, int[] arr) {
		for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
			int c1 = w1.charAt(i) - 'a', c2 = w2.charAt(i) - 'a';
			if (arr[c1] < arr[c2 ]) return true;
			else if (arr[c1] > arr[c2]) return false;
		}
		if (w1.length() > w2.length()) return false;
		return true;
	}
}
