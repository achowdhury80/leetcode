package comp.prep2019.less1000;

public class Prob79 {
	/**
	 * O(N.4^L) where L is the length of word
	 * O(L) space
	 * trick - xoring with 256 to maintain visited
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
	    for (int i = 0; i < board.length; i++) {
	    	for (int j = 0; j < board[0].length; j++) {
	    		if (exists(board, word, 0, i, j)) return true;
	    	}
	    }
	    return false;
	}

	private boolean exists(char[][] board, String word, int start, int row, int col) {
		if (start == word.length()) return true;
		if (row < 0 || row == board.length || col < 0 || col == board[0].length 
				|| board[row][col] != word.charAt(start)) return false;
		board[row][col] ^= 256;
		boolean found = exists(board, word, start + 1, row, col + 1)
				|| exists(board, word, start + 1, row, col - 1)
				|| exists(board, word, start + 1, row + 1, col)
				|| exists(board, word, start + 1, row - 1, col);
		board[row][col] ^= 256;
		return found;
	}
}
