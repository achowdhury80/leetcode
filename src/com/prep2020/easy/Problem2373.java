package com.prep2020.easy;

public class Problem2373 {
	public int[][] largestLocal(int[][] grid) {
        int[][] answer = new int[grid.length-2][grid.length-2];
        
        for(int i=0; i<answer.length; i++) {
            for(int j=0; j<answer.length; j++) {
                answer[i][j] = localMax(grid, i, j);
            }
        }
        return answer;
    }
    
    private int localMax(int[][] arr, int sIndex,int eIndex) {
        int max = Integer.MIN_VALUE;
        for(int i=sIndex; i<(sIndex+3); i++) {
            for(int j=eIndex; j<(eIndex+3); j++) {
                if(arr[i][j] > max) max = arr[i][j];
            }
        }
        return max;
    }
}
