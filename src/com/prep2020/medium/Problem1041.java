package com.prep2020.medium;

public class Problem1041 {
	public boolean isRobotBounded(String instructions) {
        char[] dir = new char[] {'N', 'E', 'S', 'W'};
        int curDir = 0;
        int[] cur = new int[] {0, 0};
        for (char c : instructions.toCharArray()) {
        	if (c == 'R') curDir = (curDir + 1) % 4;
        	else if (c == 'L') curDir = (curDir + 3) % 4;
        	else {
        		if (curDir == 0) cur[1]++;
        		else if (curDir == 1) cur[0]++;
        		else if (curDir == 2) cur[1]--;
        		else cur[0]--;
        	}
        }
        return curDir != 0 || (cur[0] == 0 && cur[1] == 0);
    }
}
