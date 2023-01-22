package com.prep2020.hard;
import java.util.*;
public class Problem1515 {
	public double getMinDistSum(int[][] positions) {
        int minX = 100, maxX = 0, minY = 100, maxY = 0;
        int xSquareSum = 0, ySquareSum = 0, n = positions.length, xSum = 0, ySum = 0;
        //Set<Integer> set = new HashSet<>();
        for (int[] p : positions) {
        	minX = Math.min(minX, p[0]);
        	maxX = Math.max(maxX, p[0]);
        	minY = Math.min(minY, p[1]);
        	maxY = Math.max(maxY, p[1]);
        	xSquareSum += p[0] * p[0];
        	ySquareSum += p[1] * p[1];
        	xSum += p[0];
        	ySum += p[1];
        	//set.add((p[0] << 7) | p[1]);
        	
        }
        int squareDist = Integer.MAX_VALUE;
        int[] pos = new int[] {-1, -1};
        for (int x = minX; x <= maxX; x++) {
        	for (int y = minY; y <= maxY; y++) {
        		//if (set.contains((x << 7) | y)) continue;
        		int curDist = xSquareSum + ySquareSum + n * (x * x + y * y) -2 * x * xSum - 2 * y * ySum;
        		if (curDist < squareDist) {
        			squareDist = curDist;
        			pos = new int[] {x, y};
        		}
        	}
        }
        double result = 0;
        for (int[] p : positions) {
        	result += Math.sqrt((p[0] - pos[0]) * (p[0] - pos[0]) + (p[1] - pos[1]) * (p[1] - pos[1]));
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1515 problem = new Problem1515();
		//System.out.println(problem.getMinDistSum(new int[][] {{0,1},{1,0},{1,2},{2,1}}));
		System.out.println(problem.getMinDistSum(new int[][] {{1,1},{0,0},{2,0}}));
	}
}
