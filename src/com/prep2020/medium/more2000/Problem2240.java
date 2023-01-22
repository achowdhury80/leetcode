package com.prep2020.medium.more2000;

public class Problem2240 {
	public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int[] arr = new int[] {cost1, cost2};
        if (arr[0] < arr[1]) {
        	int temp = arr[0];
        	arr[0] = arr[1];
        	arr[1] = temp;
        }
        long result = 0;
        int cur = 0;
        while(cur <= total) {
        	result += ((total - cur) / arr[1]) + 1;
        	cur += arr[0];
        }
        return result;
    }
}
