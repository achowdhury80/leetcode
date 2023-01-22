package com.prep2020.medium;

public class Problem277 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	public int findCelebrity(int n) {
		int celeb = 0;
        for (int i = 1; i < n; i++) {
        	if (!knows(i, celeb)) celeb = i;
        }
        for (int i = 0; i < n; i++) 
        	if (i != celeb && (knows(celeb, i) || !knows(i, celeb))) return -1;
        return celeb;
    }
	boolean knows(int a, int b) {
		return true;
	}
}
