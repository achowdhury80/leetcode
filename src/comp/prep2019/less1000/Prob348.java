package comp.prep2019.less1000;

public class Prob348 {
	private char[][] grid;
	/** Initialize your data structure here. */
    public Prob348(int n) {
        grid = new char[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
    	char c = player == 1 ? 'X' : 'O';
        grid[row][col] = c;
        boolean flag = true;
        for (int i = 0; i < grid.length; i++) {
        	if (grid[row][i] != c) {
        		flag = false;
        		break;
        	}
        }
        if (flag) return player;
        flag = true;
        for (int i = 0; i < grid.length; i++) {
        	if (grid[i][col] != c) {
        		flag = false;
        		break;
        	}
        }
        if (flag) return player;
        if (row == col) {
        	flag = true;
        	for (int i = 0; i < grid.length; i++) {
        		if (grid[i][i] != c) {
            		flag = false;
            		break;
            	}
        	}
        	if (flag) return player;
        }
        if (row == col || row == grid.length - col - 1) {
        	flag = true;
        	for (int i = 0; i < grid.length; i++) {
        		if (grid[i][grid.length - i - 1] != c) {
            		flag = false;
            		break;
            	}
        	}
        	if (flag) return player;
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	Prob348 prob = new Prob348(3);
    	System.out.println(prob.move(0, 0, 1));
    	System.out.println(prob.move(0, 2, 2));
    }
}
