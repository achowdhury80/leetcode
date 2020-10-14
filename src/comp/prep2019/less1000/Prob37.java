package comp.prep2019.less1000;

public class Prob37 {
	public void solveSudoku(char[][] board) {
        helper(board, 0);
    }
	
	private boolean helper(char[][] board, int start) {
		if (start == 81) return true;
		int[] pos = new int[] { start / 9, start % 9};
		if (board[pos[0]][pos[1]] != '.') return helper(board, start + 1);
		for (int i = 1; i < 10; i++) {
			board[pos[0]][pos[1]] = (char)('0' + i);
			if (isValid(board, pos) && helper(board, start + 1)) return true; 
			board[pos[0]][pos[1]] = '.';
		}
		return false;
	}
	
	private boolean isValid(char[][] board, int[] pos) {
		int startRow = (pos[0] / 3) * 3;
	    int startCol = (pos[1] / 3) * 3;
		int[] boxPos = new int[] {startRow, startCol};
		for (int i = 0; i < 9; i++) {
			if (i != pos[0] && board[i][pos[1]] == board[pos[0]][pos[1]]) return false;
			if (i != pos[1] && board[pos[0]][i] == board[pos[0]][pos[1]]) return false;
			if (boxPos[0] == pos[0] && boxPos[1] == pos[1]) continue;
			if (board[boxPos[0]][boxPos[1]] == board[pos[0]][pos[1]]) return false;
			boxPos[1]++;
			if (boxPos[1] % 3 == 0) {
				boxPos[0]++;
				boxPos[1] = startCol;
			}
		}
		return true;
	}
}
