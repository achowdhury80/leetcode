package com.prep2020.medium;

public class Problem1835 {
	/**
	 * O(m + n)
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int getXORSum(int[] arr1, int[] arr2) {
		int result = 0;
        for (int i = 0; i < 31; i++) {
        	int oneCount1st = 0, oneCount2nd = 0;
        	for (int num : arr1) if ((num & (1 << i)) != 0) oneCount1st++;
        	for (int num : arr2) if ((num & (1 << i)) != 0) oneCount2nd++;
        	 if ((oneCount1st * oneCount2nd) % 2 == 1) result |= (1 << i);
        }
        return result;
    }
}
