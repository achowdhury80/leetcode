package com.prep2020.medium;

public class Problem794 {
	public boolean validTicTacToe(String[] board) {
		int xCount = 0, yCount = 0;
        for (String s : board) {
        	for (char c : s.toCharArray()) {
        		if (c == 'X') xCount++;
        		else if (c == 'O') yCount++;
        	}
        }
        if (xCount < yCount || xCount > yCount + 1) return false;
        boolean xWins = wins(board, 'X'), yWins = wins(board, 'O');
        if (xWins && (xCount == yCount) || yWins && (xCount > yCount)) 
        	return false;
        return !(xWins & yWins);
    }
	
	private boolean wins(String[] board, char c) {
		String winStr = "" + c + c + c;
		for (String s : board) if (s.equals(winStr)) return true;
		boolean found = true;
		for (int i = 0; i < 3; i++) {
			for (String s : board) {
				if (s.charAt(i) != c) {
					found = false;
					break;
				}
			}
			if (found) return true;
			found = true;
		}
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(i) != c) {
				found = false;
				break;
			}
		}
		if (found) return true;
		found = true;
		
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(2 - i) != c) {
				found = false;
				break;
			}
		}
		return found;
	}
	
	public static void main(String[] args) {
		Problem794 problem = new Problem794();
		System.out.println(problem.validTicTacToe(new String[] {"XOX","O O","XOX"}));
	}
}
