package comp.prep2019;

public class Prob723 {
	public int[][] candyCrush(int[][] board) {
	    int m = board.length, n = board[0].length;
	    boolean[][] state = new boolean[m][n];
	    while (true) {
	      if (toBeCrushed(board, state)) slideDown(board, state);
	      else break;
	    }
	    return board;

	  }

	  private boolean toBeCrushed(int[][] board, boolean[][] state){
	    int m = board.length, n = board[0].length;
	    boolean result = false;
	    for (int i = 0; i < m; i++)
	      for (int j = 0; j < n; j++) {
	        state[i][j] = toBeCrushed(board, i, j);
	        result |= state[i][j];
	      }
	    return result;
	  }

	  private boolean toBeCrushed(int[][] board, int i, int j) {
	    int m = board.length, n = board[0].length;
	    if (board[i][j] == 0) return false;
	    if (i + 2 < m && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j]) return true;
	    if (i + 1 < m && i - 1 > - 1 && board[i][j] == board[i + 1][j] && board[i][j] == board[i - 1][j]) return true;
	    if (i - 2 > - 1 && board[i][j] == board[i - 1][j] && board[i][j] == board[i - 2][j]) return true;
	    if (j + 2 < n && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2]) return true;
	    if (j + 1 < n && j - 1 > - 1 && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j - 1]) return true;
	    if (j - 2 > - 1 && board[i][j] == board[i][j - 1] && board[i][j] == board[i][j - 2]) return true;
	    return false;
	  }


	  private void slideDown(int[][] board, boolean[][] state) {
	    int m = board.length, n = board[0].length;
	    for (int j = 0; j < n; j++) {
	      int k = m - 1;
	      for (int i = m - 1; i > -1; i--) {
	        if (state[i][j]) {
	          board[i][j] = 0;
	          state[i][j] = false;
	        }
	        else board[k--][j] = board[i][j];
	      }
	      while (k > -1) board[k--][j] = 0;
	    }
	    //System.out.println("After slide down...");
	    //printBoard(board);
	  }
}
