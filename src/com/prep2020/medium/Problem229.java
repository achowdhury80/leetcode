package com.prep2020.medium;
import java.util.*;
public class Problem229 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public List<Integer> majorityElement(int[] nums) {
		int n = nums.length;
        int[][] arr = new int[2][2];
        for (int num : nums) {
        	if (arr[0][0] == num) arr[0][1]++;
        	else if (arr[1][0] == num) arr[1][1]++;
        	else if (arr[0][1] == 0) {
        		arr[0][0] = num;
        		arr[0][1]++;
        	} else if (arr[1][1] == 0){
        		arr[1][0] = num;
        		arr[1][1]++;
        	} else {
        		arr[0][1]--;
        		arr[1][1]--;
        	}
        }
        arr[0][1] = 0;
		arr[1][1] = 0;
        for (int num : nums) {
        	if (num == arr[0][0]) arr[0][1]++;
        	else if (num == arr[1][0]) arr[1][1]++;
        }
        List<Integer> result = new ArrayList<>();
        if (arr[0][1] > n / 3) result.add(arr[0][0]);
        if (arr[1][1] > n / 3) result.add(arr[1][0]);
        return result;
    }
}
