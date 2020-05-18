package comp.prep2019;

public class Prob36 {
	public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
        	if (!isValidRow(board, i) || !isValidCol(board, i) 
        			|| !isValidSqr(board, i)) return false;
        }
        return true;
    }
	
	private boolean isValidRow(char[][] board, int i) {
		boolean[] arr = new boolean[10];
		for (int j = 0; j < 9; j++) {
			if (board[i][j] != '.') {
				int n = board[i][j] - '0';
				if (arr[n] == true) return false;
				arr[n] = true;
			}
		}
		return true;
	}
	
	private boolean isValidCol(char[][] board, int i) {
		boolean[] arr = new boolean[10];
		for (int j = 0; j < 9; j++) {
			if (board[j][i] != '.') {
				int n = board[j][i] - '0';
				if (arr[n] == true) return false;
				arr[n] = true;
			}
		}
		return true;
	}
	
	private boolean isValidSqr(char[][] board, int i) {
		int r = (i / 3) * 3 , c = (i % 3) * 3;
		boolean[] arr = new boolean[10];
		for (int x = r; x < r + 3; x++) {
			for (int y = c; y < c + 3; y++) {
				if (board[x][y] != '.') {
					int n = board[x][y] - '0';
					if (arr[n] == true) return false;
					arr[n] = true;
				}
			}
		}
		return true;
	}
}
