package com.prep2020.medium;
import java.util.*;
public class Problem1986 {
	public int minSessions(int[] tasks, int st)
    {
        Arrays.sort(tasks);
        reverse(tasks);
        int n = (1<<tasks.length)-1;
        int[][] memo = new int[n][st+1];
        for(int[] od:memo)
        {
            Arrays.fill(od,-1);
        }
        
        return solve(tasks,0,0,st,memo);
    }
    
    
    public void reverse(int[] tasks)
    {
        int i = 0,j = tasks.length-1;
        while(i<j)
        {
            int temp = tasks[i];
            tasks[i] = tasks[j];
            tasks[j] = temp;
            i++;
            j--;
        }
    }
    
    public int solve(int[] tasks,int mask,int rt,int st,int[][]memo)
    {
        
        if((mask ^ ((1<<tasks.length)-1))==0) return 0;
        if(memo[mask][rt]!=-1) return memo[mask][rt];
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<tasks.length;i++)
        {
            if((mask&(1<<i))==0)
            {
                if(rt>=tasks[i])
                {
                    min = Math.min(min,solve(tasks,(mask|(1<<i)),rt-tasks[i],st,memo));
                }
                else
                {
                    min = Math.min(min, 1+ solve(tasks,(mask|(1<<i)),st-tasks[i],st,memo));
                }
            }
        }
        
        return memo[mask][rt] = min;

    }
	
	public static void main(String[] args) {
		Problem1986 problem = new Problem1986();
		System.out.println(problem.minSessions(new int[] {1, 2, 3}, 3));
	}
}
