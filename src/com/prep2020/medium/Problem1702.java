package com.prep2020.medium;

public class Problem1702 {
	/**
	 * https://leetcode.com/problems/maximum-binary-string-after-change/discuss/1582456/Java-O(n)-time-and-space-easy-to-read
	 * O(N)
	 * @param binary
	 * @return
	 */
	public String maximumBinaryString(String binary) {
		char[] arr = binary.toCharArray();
		int n = arr.length;
		int iZero = -1;
        for (int i = 0; i < n; i++) {
        	if (arr[i] == '0' && iZero == -1) {
        		iZero = i;
        		continue;
        	}
        	if (arr[i] == '0' && iZero == i - 1) {
        		arr[iZero] = '1';
        		iZero = i;
        		continue;
        	}
        	if (arr[i] == '0') {
        		arr[iZero] = '1';
        		arr[++iZero] = '0';
        		arr[i] = '1';
        	}
        }
        return new String(arr);
    }
}
