package com.prep2020.medium;

public class Problem1769 {
	/**
	 * O(N)
	 * @param boxes
	 * @return
	 */
	public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        int[] toMoveRight = new int[2], toMoveLeft = new int[2];
        for (int i = 0; i < boxes.length(); i++) {
        	toMoveRight[0] +=  toMoveRight[1];
        	toMoveLeft[0] += toMoveLeft[1];
        	if (i > 0) {
        		if (boxes.charAt(i - 1) == '1') {
        			toMoveRight[0]++;
        			toMoveRight[1]++;
        		}
        		if (boxes.charAt(boxes.length() - i) == '1') {
        			toMoveLeft[0]++;
        			toMoveLeft[1]++;
        		}
        	}
        	result[i] += toMoveRight[0];
        	result[boxes.length() - i - 1] += toMoveLeft[0];
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1769 problem = new Problem1769();
		//int[] result = problem.minOperations("110");
		int[] result = problem.minOperations("001011");
		System.out.println(result);
	}
}
