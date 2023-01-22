package com.prep2020.hard;
import java.util.*;
public class Problem2172 {
	public int maximumANDSum(int[] nums, int numSlots) {
        Map<String, Integer> memo = new HashMap<>();
        int[] slots = new int[numSlots + 1];
        return recur(nums, slots, numSlots, 0, memo);
    }
    
    private int recur(int[] nums, int[] slots, int numSlots, int index, Map<String, Integer> memo) {
        
        if (index == nums.length) {
            return 0;
        }
        String key = Arrays.toString(slots) + "|" + index;
        
        if (memo.get(key) != null) {
            return memo.get(key);
        }
        int ans = 0;
        
        for (int i = 1; i <= numSlots; i++) {
            
            if (slots[i - 1] < 2) {
                slots[i - 1]++;
                int temp = (nums[index] & i) + recur(nums, slots, numSlots, index + 1, memo);
                ans = Math.max(ans, temp);
                slots[i - 1]--;
            }
        }
        memo.put(key, ans);
        return ans;
    }
}
