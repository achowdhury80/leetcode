package com.prep2020.medium;

import java.util.Arrays;

public class Problem179 {
	/**
	 * O(nlogn)
	 * @param nums
	 * @return
	 */
	public String largestNumber(int[] nums) {
		if(nums.length == 0) return "";
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = "" + nums[i];
        Arrays.sort(arr, (x, y) -> (y + x).compareTo(x + y));
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        while (sb.length() > 1 && sb.charAt(0) == '0') sb = sb.deleteCharAt(0);
        return sb.toString();
    }
}
