package comp.prep2019;

public class Prob289 {
	public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int liveNeighbor = findLiveNeighbor(board, new int[] {i, j});
        		if (board[i][j] == 1) {
        			if (liveNeighbor == 2 || liveNeighbor == 3) {
        				board[i][j] ^= 2;
        			}
        		} else {
        			if (liveNeighbor == 3) board[i][j] ^= 2;;
        		}
        	}
        }
        for(int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		board[i][j] >>= 1;
        	}
        }
    }
	
	private int findLiveNeighbor(int[][] board, int[] cur) {
		int[][] dirs = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1},
			{1, -1}, {1, 0}, {1, 1}};
		int result = 0;
		for (int[] dir : dirs) {
			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
			if (next[0] < 0 || next[0] >= board.length || next[1] < 0 
					|| next[1] >= board[0].length) continue;
			if ((board[next[0]][next[1]] & 1) == 1) result++;
		}
		return result;
	}
}
