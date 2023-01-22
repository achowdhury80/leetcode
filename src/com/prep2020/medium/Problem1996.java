package com.prep2020.medium;

import java.util.Arrays;

public class Problem1996 {
	public int numberOfWeakCharacters(int[][] properties) {
		int res=0;
        Arrays.sort(properties,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int min=Integer.MIN_VALUE;
        for(int i=properties.length-1;i>=0;i--){
            int defense=properties[i][1];
            if(defense<min){
                res++;
            }
            min=Math.max(min,defense);
        }
        return res;
        
    }
	
	public static void main(String[] args) {
		Problem1996 problem = new Problem1996();
		System.out.println(problem.numberOfWeakCharacters(new int[][] {{5,4}, {5, 5}}));
	}
}


