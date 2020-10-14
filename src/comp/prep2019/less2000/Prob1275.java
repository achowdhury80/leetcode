package comp.prep2019.less2000;

public class Prob1275 {
	//O(1)
	public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
        	int player = (i % 2 == 0 ? 1 : 5);
        	if (isWin(grid, moves[i], player)) {
        		if (i % 2 == 0) return "A";
        		else return "B";
        	}
        }
        if (moves.length == 9) return "Draw";
        return "Pending";
    }
	
	private boolean isWin(int[][] grid, int[] move, int player) {
		grid[move[0]][move[1]] = player;
		boolean flag = true;
		for (int i = 0; i < 3; i++) {
			if (grid[i][move[1]] != player) {
				flag = false;
				break;
			}
		}
		if (flag) return true;
		flag = true;
		for (int i = 0; i < 3; i++) {
			if (grid[move[0]][i] != player) {
				flag = false;
				break;
			}
		}
		if (flag) return true;
		if (move[0] == move[1]) {
			flag = true;
			for (int i = 0; i < 3; i++) {
				if (grid[i][i] != player) {
					flag = false;
					break;
				}
			}
			if (flag == true) return true;
		}
		if (move[0] + move[1] == 2) {
			flag = true;
			for (int i = 0; i < 3; i++) {
				if (grid[i][2 - i] != player) {
					flag = false;
					break;
				}
			}
			if (flag == true) return true;
		}
		return false;
	}
}
