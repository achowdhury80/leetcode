package comp.prep2019.less1000;

public class Prob794 {
	public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String s : board) {
        	for (char c : s.toCharArray()) {
        		if (c == 'X') xCount++;
        		else if (c == 'O') oCount++;
        	}
        }
        if (xCount < oCount || xCount - oCount > 1) return false;
        boolean xWins = wins(board, 'X'), oWins = wins(board, 'O');
        if (xWins && oWins) return false;
        if ((xWins && xCount == oCount) || (oWins && xCount > oCount)) return false;
        return true;
    }
	
	private boolean wins(String[] b, char c) {
		String s = "" + c + c + c;
		for (int i = 0; i < 3; i++) {
			if (b[i].equals(s)) return true;
			if (s.equals("" + b[0].charAt(i) + b[1].charAt(i) + b[2].charAt(i))) return true;
		}
		if (s.equals("" + b[0].charAt(0) + b[1].charAt(1) + b[2].charAt(2))) return true;
		if (s.equals("" + b[0].charAt(2) + b[1].charAt(1) + b[2].charAt(0))) return true;
		return false;
		
	}
}
