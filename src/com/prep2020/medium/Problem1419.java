package com.prep2020.medium;

public class Problem1419 {
	/**
	 * O(N)
	 * @param croakOfFrogs
	 * @return
	 */
	public int minNumberOfFrogs(String croakOfFrogs) {
        String sound = "croak";
        int[] count = new int[sound.length()];
        int result = 0;
        for (char c : croakOfFrogs.toCharArray()) {
        	int idx = sound.indexOf(c);
        	count[idx]++;
        	if (idx > 0 && count[idx] > count[idx - 1]) return -1;
        	result = Math.max(result, count[0]);
        	if (idx == 4) {
        		for (int i = 0; i < sound.length(); i++) count[i]--;
        	}
        }
        for (int i = 1; i < sound.length(); i++) if (count[i] != count[i - 1]) return -1;
        return result;
    }
}
