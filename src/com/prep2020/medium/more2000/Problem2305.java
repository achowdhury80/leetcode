package com.prep2020.medium.more2000;

public class Problem2305 {
	public int distributeCookies(int[] cookies, int k) {
        int[] dist = new int[k];
		// dist[i] is the amount of cookies ith children has
        return helper(cookies,dist,k,0,0);
    }
    public int helper(int[] cookies, int[] dist, int k, int i, int max){
	//max is the unfairness of the current distribution till now; 
        if(i==cookies.length){
            return max;
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            dist[j]+=cookies[i];
            int max2 = Math.max(max,dist[j]);
            min = Math.min(helper(cookies,dist,k,i+1,max2),min);  //minimum unfairness
            dist[j]-=cookies[i];
        }
        return min;
    }
}
