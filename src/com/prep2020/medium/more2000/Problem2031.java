package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2031 {
	/**
	 * https://leetcode.com/problems/count-subarrays-with-more-ones-than-zeros/discuss/1525651/CJava-One-pass-O(n)-solution
	 * @param nums
	 * @return
	 */
public int subarraysWithMoreZerosThanOnes(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        
        int res = 0, cnt = 0, prefixSum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
            {
			    // update prefixSum  
                prefixSum++;
				// any subarray that has prefix sum equals (prefixSum - 1) will become new valid subarray
                cnt += map.getOrDefault(prefixSum - 1, 0);
            }
            else
            {
			    // replace 0 with -1, then update prefixSum  
                prefixSum--;
				// any subarray that has prefix sum equals prefixSum will become invalid
                cnt -= map.getOrDefault(prefixSum, 0);
            }
            
            res += cnt;
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            res %= 1000000007;
        }
        
        return res;
    }
}
