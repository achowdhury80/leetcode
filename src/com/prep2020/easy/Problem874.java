package com.prep2020.easy;
import java.util.*;
public class Problem874 {
	public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) set.add(obs[0] + "#" + obs[1]);
        int[] cur = new int[] {0, 0};
        int[][] dirs = new int[][]{{0,1},{-1, 0},{0, -1},{1, 0}};
        int curDir = 0;
        int result = 0;
        for (int com : commands) {
        	if (com == -2) curDir = (curDir + 1) % 4;
        	else if (com == -1) curDir = (curDir + 3) % 4;
        	else {
        		for (int j = 0; j < com; j++) {
        			int[] next = new int[] {cur[0] + dirs[curDir][0],
        					cur[1] + dirs[curDir][1]};
        			if (!set.contains(next[0] + "#" + next[1])) {
        				cur = next;
        				result = Math.max(result, cur[0] * cur[0] + cur[1] * cur[1]);
        			} else break;
        		}
        	}
        }
        return result;
    }
}
