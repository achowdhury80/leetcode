package comp.prep2019.less1000;
import java.util.*;
public class Prob489 {
	/**
	 * O(m * n)
	 */
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
	    		// gets back to prev position with direction opposited
	    		robot.move();
	    		robot.turnRight();
	    		robot.turnRight(); 
	    		// direction set to previous
    		}
    		// try next direction
    		robot.turnRight();
    	}
    }
	
	interface Robot {
		      // Returns true if the cell in front is open and robot moves into the cell.
		      // Returns false if the cell in front is blocked and robot stays in the current cell.
		      public boolean move();
		 
		      // Robot will stay in the same cell after calling turnLeft/turnRight.
		      // Each turn will be 90 degrees.
		      public void turnLeft();
		      public void turnRight();
		 
		      // Clean the current cell.
		      public void clean();
		  }
}
