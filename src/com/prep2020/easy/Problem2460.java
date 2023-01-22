package com.prep2020.easy;

public class Problem2460 {
	public int[] applyOperations(int[] nums) {
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]*=0;
            }
        }

        int j=nums.length-1;
        int p=0;
        for(int i=0;i<ans.length;i++){
            if(nums[i]==0)
                ans[j--]=0;
            else
                ans[p++]=nums[i];
        }
        return ans;
    }
}
