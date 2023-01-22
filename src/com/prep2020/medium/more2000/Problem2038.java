package com.prep2020.medium.more2000;
public class Problem2038 {
	/**
	 * O(N)
	 * @param colors
	 * @return
	 */
	public boolean winnerOfGame(String colors) {
        int[] counts = new int[2];
        int last = 0;
        for (int i = 1; i < colors.length(); i++) {
        	char c = colors.charAt(i);
        	if (c != colors.charAt(last)) {
        		if (i - last > 2) 
        			counts[colors.charAt(last) - 'A'] += i - last - 2;
        		last = i;
        	}
        }
        if (colors.length() - last > 2) 
        	counts[colors.charAt(last) - 'A'] += colors.length() - last - 2;
        return counts[0] > counts[1];
    }
	
	public static void main(String[] args) {
		Problem2038 problem = new Problem2038();
		System.out.println(problem.winnerOfGame("AABB"));
		System.out.println(problem.winnerOfGame("BBAAABBABBABB"));
	}
}
