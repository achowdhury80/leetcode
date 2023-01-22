package com.leet.algo;
import java.util.*;
public class Prob982 {
	/**
	 * O(N^2) time and space
	 * @param A
	 * @return
	 */
	public int countTriplets(int[] nums) {
        int count=0;
        Map<Integer,Integer>dp=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length;j++)
                dp.put(nums[i]&nums[j],dp.getOrDefault(nums[i]&nums[j],0)+1);
        for(Map.Entry<Integer,Integer>m : dp.entrySet())
            for(int num :  nums) if(((int)(m.getKey()&num))==0)count+=m.getValue();
        return count;
                
    }
}
