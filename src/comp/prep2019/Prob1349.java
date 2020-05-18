package comp.prep2019;
import java.util.*;
public class Prob1349 {
	public int maxStudents(char[][] seats) {
		Set<Long> visited = new HashSet<>();
        visited.add(0l);
        int[] result = new int[1];
        helper(seats, visited, new int[] {0, 0}, 0, result, 0);
        return result[0];
    }
	
	private void helper(char[][] seats, Set<Long> visited, int[] start, long state,
			int[] result, int count) {
		int[] nextPos = findNextPos(seats, start);
		if (seats[start[0]][start[1]] == '.' && canSeat(seats, start)) {
			int pos = seats[0].length * start[0] + start[1];
			long newState = state | (1l << pos);
			seats[start[0]][start[1]] = 'p';
			if (!visited.contains(newState)) {
				visited.add(newState);
				result[0] = Math.max(result[0], count + 1);
				if (nextPos != null) helper(seats, visited, nextPos, newState, result, count + 1);
			}
			seats[start[0]][start[1]] = '.';
		}
		if (nextPos != null) helper(seats, visited, nextPos, state, result, count);
	}
	
	private int[] findNextPos(char[][] seats, int[] start) {
		if (start[1] < seats[0].length - 1) return new int[] {start[0], start[1] + 1};
		if (start[0] < seats.length - 1) return new int[] {start[0] + 1, 0};
		return null;
	}

	private boolean canSeat(char[][] seats, int[] pos) {
		int[][] dirs = new int[][] {{-1, -1}, {-1, 1}, {0, -1}, {0, 1}};
		for (int[] dir : dirs) {
			int[] next = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
			if (next[0] > -1 && next[0] < seats.length && next[1] > -1 
					&& next[1] < seats[0].length && seats[next[0]][next[1]] == 'p') 
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Prob1349 prob = new Prob1349();
		System.out.println(prob.maxStudents(new char[][] {
			{'#','.','#','#','.','#'},
			{'.','#','#','#','#','.'},
			{'#','.','#','#','.','#'}}));
	}
	
	
}
