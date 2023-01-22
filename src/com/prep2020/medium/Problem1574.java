package com.prep2020.medium;

public class Problem1574 {
	public int findLengthOfShortestSubarray(int[] arr) {
		int start=0;
        int n=arr.length;
        int end=n-1;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            if(arr[i]<=arr[i+1])
                start=i+1;
            else
                break;
        }
        if(start==n-1)
            return 0;
        for(int i=n-1;i>0;i--){
            if(arr[i-1]<=arr[i])
                end=i-1;
            else
                break;
        }
        if(end==0)
            return n-1;
        ans=Math.min(n-start-1,end);
        int i=0;
        int j=end;
        while(i<=start && j<n){
            if(arr[i]<=arr[j]){
                ans=Math.min(ans,j-i-1);
                i++;
            }
            else
                j++;
        }
        
        return ans; 
    }
}
