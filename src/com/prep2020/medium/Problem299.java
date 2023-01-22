package com.prep2020.medium;

public class Problem299 {
	/**
	 * O(N)
	 * @param secret
	 * @param guess
	 * @return
	 */
	public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
        	char c;
        	if ((c = secret.charAt(i)) == guess.charAt(i)) bulls++;
        	else count[c - '0']++;
        }
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
        	char c;
        	if ((c = guess.charAt(i)) != secret.charAt(i)) {
        		int idx = c - '0';
        		if (count[idx] > 0) {
        			cows++;
        			count[idx]--;
        		}
        	}
        }
        return bulls + "A" + cows + "B";
    }
}
