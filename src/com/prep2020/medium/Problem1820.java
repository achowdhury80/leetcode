package com.prep2020.medium;

import java.util.Arrays;

public class Problem1820 {
	/**
	 * https://leetcode.com/problems/maximum-number-of-accepted-invitations/discuss/1702832/Java-or-Bipartite-graph-or-MCBM-augmenting-path-algorithm
	 * @param grid
	 * @return
	 */
	public int maximumInvitations(int[][] grid) {
        // max cardinality bipartite matching (MCBM)
        // m - boys, n - girls
        int m= grid.length, n= grid[0].length;
        // match[j] := index of matched boy i for a girl j
        int[] match= new int[n];
        Arrays.fill(match, -1);
        // visited[i] := boy i visited in a single MCBM augmented path algo execution
        boolean[] visited= new boolean[m];
        int mcbm= 0;
        for(int i=0; i<m; i++){
            Arrays.fill(visited, false);
            mcbm+= augment(match, i, grid, visited);
        }        
        return mcbm;
    }
    
    int augment(int[] match, int i, int[][] grid, boolean[] visited){
        if(visited[i]) return 0;
        visited[i]= true;
        for(int n=grid[i].length, j=0; j<n; j++)
            if(grid[i][j]==1 && (match[j]==-1 || augment(match, match[j], grid, visited)==1)){
                match[j]= i;
                return 1;
            }
        return 0;
    }
}
