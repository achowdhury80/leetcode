package com.prep2020.medium;
/**
 * https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1991407/Java-or-time%3A-O(nm)-space%3A-O(n)-or-DP
 * @author aychowdh
 *
 */
public class Problem1937 {
	public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        
        long[] pre = new long[m];
        
        for(int[] point : points) {
            long[] current = new long[m];
			
            long max = Long.MIN_VALUE;
            for(int j=0; j<m; j++) {     //iterate from left to right column, the current maximum point is the maximum point from index 0 to j. 
                max = Math.max(max, pre[j] + j);    
                current[j] = Math.max(current[j], point[j]-j+max); 
            }
            
            max = Long.MIN_VALUE;
            for(int j=m-1; j>=0; j--) {    //iterate from right to left column, the current maximum point is the maximum point from index m-1 to j. 
                max = Math.max(max, pre[j] - j);
                current[j] = Math.max(current[j], point[j]+j+max);
            }
            pre = current;
        }
        
        long max = Long.MIN_VALUE;
        for(long val : pre) {
            max = Math.max(max, val);
        }
        return max;
	}
}
