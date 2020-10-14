package comp.prep2019.less1000;
import java.util.*;
public class Prob874 {
	public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        int[][] dirs = new int[][]{{0,1},{1, 0},{0, -1},{-1, 0}};
        for (int i = 0; i < obstacles.length; i++) {
        	set.add(obstacles[i][0] + "-" + obstacles[i][1]);
        }
        int[] currentPos = new int[] {0, 0};
        int curDirIdx = 0;
        int result = 0;
        for (int i = 0; i < commands.length; i++) {
        	if (commands[i] == -2) curDirIdx = (curDirIdx + 3) % 4;
        	else if (commands[i] == -1) curDirIdx = (curDirIdx + 1) % 4;
        	else {
        		for (int j = 0; j < commands[i]; j++) {
        			int[] next = new int[] {currentPos[0] + dirs[curDirIdx][0],
        					currentPos[1] + dirs[curDirIdx][1]};
        			if (!set.contains(next[0] + "-" + next[1])) {
        				currentPos = next;
        				result = Math.max(result, currentPos[0] * currentPos[0] + currentPos[1] * currentPos[1]);
        			} else break;
        		}
        		
        	}
        	
        }
        return result;
    }
}
