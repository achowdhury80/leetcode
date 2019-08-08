package com.leet.algo;
import java.util.*;
public class Prob489 {
	private int[][] dirs = new int[][] {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	public void cleanRoom(Robot robot) {
		cleanRoom(robot, new int[] {0, 0}, 0, new HashSet<>());
    }
	
    private void cleanRoom(Robot robot, int[] curPos, int dirIndex, Set<String> seen) {
    	String key = curPos[0] + "->" + curPos[1];
    	if (seen.contains(key)) return;
    	seen.add(key);
    	robot.clean();
    	for (int i = 0; i < dirs.length; i++) {
    		int nextDirIndex = (dirIndex + i) % 4;
    		int[] nextPos = new int[] {curPos[0] + dirs[nextDirIndex][0], curPos[1] + dirs[nextDirIndex][1]};
    		if(robot.move()) {
	    		cleanRoom(robot, nextPos, nextDirIndex, seen);
	    		robot.turnRight();
	    		robot.turnRight();
	    		robot.move();
	    		robot.turnRight();
	    		robot.turnRight(); 
    		}
    		robot.turnRight();
    	}
    }
}
