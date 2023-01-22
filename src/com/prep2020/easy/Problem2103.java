package com.prep2020.easy;

public class Problem2103 {
	/**
	 * O(N)
	 * @param rings
	 * @return
	 */
	public int countPoints(String rings) {
        int[] rods = new int[10];
        char[] arr = rings.toCharArray();
        for (int i = 0; i < arr.length; i += 2) {
        	int colorIdx = "RGB".indexOf(arr[i]);
        	int rodIdx = arr[i + 1] - '0';
        	rods[rodIdx] |= (1 << colorIdx);
        }
        int result = 0;
        for (int i = 0; i < 10; i++) if (rods[i] == 7) result++;
        return result;
    }
}
