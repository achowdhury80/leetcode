package com.leet.algo;
import java.util.*;
public class Prob967 {
	public int[] numsSameConsecDiff(int N, int K) {
        List<Integer>[] dp = new List[N + 1];
        dp[1] = (List<Integer>)Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        int devider = 1;
        for (int i = 2; i < N + 1; i++) {
        	dp[i] = new ArrayList<Integer>();
        	List<Integer> list = dp[i - 1];
        	for(int num : list) {
        		int digit = num / devider;
        		if (digit + K < 10) {
        			int next = (digit + K) * 10 * devider + num;
        			if(i == N && digit + K == 0) continue;
        			dp[i].add(next);
        		} 
        		if (digit - K > -1  && digit - K != digit + K) {
        			int next = Math.abs(digit - K) * 10 * devider + num;
        			if(i == N && digit - K == 0) continue;
        			dp[i].add(next);
        		}
        	}
        	devider *=10;
        }
        int[] result = new int[dp[N].size()];
        for (int i = 0; i < dp[N].size(); i++) result[i] = (int)dp[N].get(i);
        return result;
    }
	
	public static void main(String[] args) {
		Prob967 prob = new Prob967();
		//int[] arr = prob.numsSameConsecDiff(3, 7);
		int[] arr = prob.numsSameConsecDiff(2, 1);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
