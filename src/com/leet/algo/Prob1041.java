package com.leet.algo;

public class Prob1041 {
	public boolean isRobotBounded(String instructions) {
		int[] pos = new int[] {0, 0};
		int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;
        for (char c : instructions.toCharArray()) {
        	if (c == 'G') pos = new int[] {pos[0] + dirs[i][0], pos[1] + dirs[i][1]};
        	else if (c == 'L') {
        		i = (i + 3) % 4;
        	} else  {
        		i = (i + 1) % 4;
        	}
        }
        return pos[0] == 0 && pos[1] == 0 || i > 0;
    }
}
