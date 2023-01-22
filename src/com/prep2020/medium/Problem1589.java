package com.prep2020.medium;
import java.util.*;
public class Problem1589 {
	public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] count = new int[100001];
        for (int[] req : requests) {
        	count[req[0]]++;
        	if (req[1] < 100000) count[req[1] + 1]--;
        }
        
        List<Integer> freq = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < 100001; i++) {
        	cur += count[i];
        	if (cur > 0) freq.add(cur);
        }
        Collections.sort(freq);
        Arrays.sort(nums);
        int idx = nums.length - 1;
        long result = 0;
        int mod = (int)(1e9 + 7);
        for (int i = freq.size() - 1; i > -1; i--) {
        	result = (result + (1l * freq.get(i) * nums[idx--])) % mod;
        }
        return (int) result;
    }
}
