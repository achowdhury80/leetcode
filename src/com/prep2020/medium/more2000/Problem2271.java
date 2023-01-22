package com.prep2020.medium.more2000;

import java.util.*;

public class Problem2271 {
	public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (x, y) -> (x[0] - y[0]));
        Deque<int[]> dq = new ArrayDeque<>();
        int result = 0;
        long curSum = 0;
        for (int i = 0; i < tiles.length; i++) {
        	int cur = tiles[i][1] - tiles[i][0] + 1;
        	if (cur >= carpetLen) return carpetLen;
        	curSum += cur;
        	dq.offerLast(tiles[i]);
        	int start = Math.max(tiles[i][1] - carpetLen + 1, 0);
        	while(!dq.isEmpty() && dq.peekFirst()[0] < start) {
        		int[] p = dq.pollFirst();
        		if (p[1] < start) {
        			curSum -= (p[1] - p[0] + 1);
        		} else {
        			curSum -= (start - p[0]);
        			p[0] = start;
        			dq.offerFirst(p);
        		}
        		
        	}
        	result = Math.max(result, (int)curSum);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2271 problem = new Problem2271();
		System.out.println(problem.maximumWhiteTiles(new int[][] {{1,5},{10,11},{12,18},{20,25},{30,32}}, 10));
	}
}
