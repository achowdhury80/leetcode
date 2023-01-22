package com.prep2020.medium;
import java.util.*;
public class Problem1878 {
	public int[] getBiggestThree(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int left, right, top, bottom;
        int curSum;
        // priority queue that stores the smallest sum at the top
        Queue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
        for(int row = 0; row < rowLen; row++){
            for(int col = 0; col < colLen; col++){
                left = right = col;
                top = bottom = row;
                // stop when any side hits the border
                while(left >= 0 && right <= colLen - 1 && bottom <= rowLen - 1){
                    curSum = calculateSum(grid, left, right, top, bottom);
                    left--;
                    right++;
                    bottom += 2;
                    
                    // add the current sum to the priority queue
                    if(!pq.contains(curSum)){
                        pq.add(curSum);   
                    }
                    if(pq.size() > 3){
                        pq.remove();
                    }
                }
            }
        }
        
        int[] arr = new int[pq.size()];
        for(int i = arr.length - 1; i >= 0; i--){
            arr[i] = pq.remove();
        }
        return arr;
    }
    
    private int calculateSum(int[][] grid, int left, int right, int top, int bottom){
        int sum = 0;
        int leftCol, rightCol;
        // find the middle column
        leftCol = rightCol = (left + right) / 2;
        boolean expand = true;
        int curRow = top;
        while(curRow <= bottom){
            if(leftCol == rightCol){
                sum += grid[curRow][leftCol];
            }else{
                sum += grid[curRow][leftCol] + grid[curRow][rightCol];
            }
            
            if(leftCol == left){
                expand = false;
            }
            
            if(expand == false){
                // shrinking
                leftCol++;
                rightCol--;
            }else{
                // expanding
                leftCol--;
                rightCol++;
            }
            curRow++;
        }
        
        return sum;
    }
}
