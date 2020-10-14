package comp.prep2019.less1000;

public class Prob419 {
	/**
	 * O(M*N)
	 * @param board
	 * @return
	 */
	public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.')
        				&& (j == 0 || board[i][j - 1] == '.')) {
        			result++;
        		}
        	}
        }
        return result;
    }
}
