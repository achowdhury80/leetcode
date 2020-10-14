package comp.prep2019.less1000;

public class Prob999 {
	public int numRookCaptures(char[][] board) {
        int m = board.length, n = board[0].length;
        int[] r = null;
        boolean found = false;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] == 'R') {
        			r = new int[] {i, j};
        			found = true;
        			break;
        		}
        	}
        	if(found) break;
        }
        int[][] dirs = new int[][] {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;
        for (int[] dir : dirs) {
        	int[] cur = new int[] {r[0], r[1]};
        	while(true) {
        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        		if (next[0] < 0 || next[0] == n || next[1] < 0 || next[1] == n) 
        			break;
        		if (board[next[0]][next[1]] == 'p') {
        			result++;
        			break;
        		} else if (board[next[0]][next[1]] == 'B') {
        			break;
        		} else cur = next;
        	}
        }
        return result;
    }
}
