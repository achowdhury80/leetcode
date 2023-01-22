package com.prep2020.medium;

public class Problem1802 {
	/**
	 * O(nlogn)
	 * @param n
	 * @param index
	 * @param maxSum
	 * @return
	 */
	public int maxValue(int n, int index, int maxSum) {
        int leftLen = index, rightLen = n - index - 1;
        int result = 1, low = 2, high = maxSum;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	long sum = mid;
        	if (mid - 1 > leftLen) {
        		sum += 1l * leftLen * (2 * mid - leftLen - 1) / 2;
        	} else {
        		sum += 1l * (mid - 1) * mid / 2 + (leftLen - mid + 1);
        	}
        	
        	if (mid - 1 > rightLen) {
        		sum += 1l * rightLen * (2 * mid - rightLen - 1) / 2;
        	} else {
        		sum += 1l * (mid - 1) * mid / 2 + (rightLen - mid + 1);
        	}
        	if (sum <= maxSum) {
        		result = mid;
        		low = mid + 1;
        	} else high = mid - 1;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1802 problem = new Problem1802();
		System.out.println(problem.maxValue(6, 1, 10));
		System.out.println(problem.maxValue(3, 2, 18));
		System.out.println(problem.maxValue(4, 0, 4));
	}
}
