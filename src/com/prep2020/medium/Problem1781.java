package com.prep2020.medium;

public class Problem1781 {
	public int beautySum(String s) 
	{
	    int res = 0;
	    int n = s.length();
	    for(int L = 3; L <= n; L++)
	    {
	        for(int i = 0; i < n-L+1; i++)
	        {
	            int j = i+L-1;
	            int[] count = new int[26];
	            for(int k = i; k <= j; k++)
	            {
	                count[s.charAt(k)-'a']++;
	            }
	            
	            res += computeBeauty(count);
	        }
	    }
	    
	    return res;
	}

	int computeBeauty(int[] count)
	{
	    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	    for(int i = 0; i < 26; i++)
	    {
	        if(count[i] > 0)
	        {
	            min = Math.min(min, count[i]);
	            max = Math.max(max, count[i]);   
	        }
	    }
	    
	    return max-min;
	}
	
	public static void main(String[] args) {
		Problem1781 problem = new Problem1781();
		System.out.println(problem.beautySum("aabcb"));
	}
}
