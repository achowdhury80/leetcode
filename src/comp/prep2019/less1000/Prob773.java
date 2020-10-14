package comp.prep2019.less1000;
import java.util.*;
public class Prob773 {
	public int slidingPuzzle(int[][] board) {
        int finalState = 123450;
        int curState = serializeBoardState(board);
        if (curState == finalState) return 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[][]> q = new LinkedList<>();
        q.offer(board);
        visited.add(curState);
        int result = 0;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[][] cur = q.poll();
        		for (int[][] next : findNextBoard(cur)) {
        			int state = serializeBoardState(next);
        			if (visited.contains(state)) continue;
        			if (finalState == state) return result;
        			visited.add(state);
        			q.offer(next);
        		}
        	}
        }
        return -1;
    }
	
	private int serializeBoardState(int[][] board) {
		int result = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				result = result * 10 + board[i][j];
			}
		}
		return result;
	}
	
	private List<int[][]> findNextBoard(int[][] board) {
		int[] pos = null;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					pos = new int[] {i, j};
					break;
				}
			}
		}
		List<int[][]> result = new ArrayList<>();
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i == 0 && j == 0) continue;
				if (i != 0 && j != 0) continue;
				int[] next = new int[] {pos[0] + i, pos[1] + j};
				if (next[0] < 0 || next[0] > 1 || next[1] < 0 || next[1] > 2) 
					continue;
				int[][] newBoard = new int[2][3];
				for (int x = 0; x < 2; x++) {
					for (int y = 0; y < 3; y++) {
						newBoard[x][y] = board[x][y];
					}
				}
				newBoard[pos[0]][pos[1]] = board[next[0]][next[1]];
				newBoard[next[0]][next[1]] = 0;
				result.add(newBoard);
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		Prob773 prob = new Prob773();
		System.out.println(prob.slidingPuzzle(new int[][] {{1,2,3},{4, 0, 5}}));
	}
}
