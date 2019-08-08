package com.leet.algo;
import java.util.*;
public class Prob1063 {
//	public int validSubarrays(int[] nums) {
//        boolean[][] dp = new boolean[nums.length][nums.length];
//        for (int i = 0; i < nums.length; i++) {
//        	dp[i][0] = true;
//        }
//        int result = nums.length;
//        for (int i = 1; i < nums.length; i++) {
//        	for (int j = 0; j < nums.length - 1; j++) {
//        		if ((j + i) < nums.length && dp[j][i - 1] && nums[j] <= nums[j + i]) {
//        			dp[j][i] = true;
//        			result++;
//        		}
//        	}
//        }
//        return result;
//    }
	
	public int validSubarrays(int[] nums) {
        int result = 0;
        Stack<Integer> s = new Stack<>();
        for (int i : nums) {
        	while(!s.empty() && s.peek() > i) s.pop();
        	s.push(i);
        	result += s.size();
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1063 prob = new Prob1063();
		System.out.println(prob.validSubarrays(new int[] {1,4,2,5,3}));
	}
}
