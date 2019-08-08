package com.leet.algo;

import java.util.Arrays;

public class Prob1024 {
	public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (x, y) -> (x[0] == y[0]) ? (x[1] - y[1]) : (x[0] - y[0]));
        if (clips[0][0] != 0) return -1;
        int result = 0, end = 0;
        for (int i = 0; i < clips.length; i++) {
        	if (clips[i][0] > end) return -1;
        	int lastEnd = end;
        	while(i < clips.length && clips[i][0] <= lastEnd) {
        		end = Math.max(end, clips[i++][1]);
        	}
        	result++;
        	i--;
        	if (end >= T) break;
        }
        if (end < T) return -1;
        return result;
    }
}
