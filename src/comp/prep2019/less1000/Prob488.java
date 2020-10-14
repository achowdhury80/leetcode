package comp.prep2019.less1000;

public class Prob488 {
	public int findMinStep(String board, String hand) {
        int[] result = new int[] {Integer.MAX_VALUE};
        helper(board, hand, result, 0, 0);
        return result[0] == Integer.MAX_VALUE ? -1 : result[0];
    }

	/**
	 * with this solution, ordering of hand does not mater
	 * @param board
	 * @param hand
	 * @param result
	 * @param steps
	 * @param last_i
	 */
	private void helper(String board, String hand, int[] result, int steps, int last_i) {
		if (board.length() == 0) {
			result[0] = Math.min(result[0], steps);
		}
		for (int i = last_i; i < hand.length(); i++) {
			char c = hand.charAt(i);
			String newHand = hand.substring(0, i) + hand.substring(i + 1);
			for (int j = 0; j <= board.length(); j++) {
				String newBoard = play(board.substring(0, j) 
						+ c + board.substring(j));
				helper(newBoard, newHand, result, steps + 1, i);
			}
		}
	}

	private String play(String board) {
		if (board.length() < 3) return board;
		int start = 0;
		for (int i = 1; i < board.length(); i++) {
			if (board.charAt(i) != board.charAt(i - 1)) {
				if (i - start >= 3)
					return play(board.substring(0, start) + board.substring(i));
				else start = i;
			}
		}
		if (board.length() - start >= 3) return play(board.substring(0, start));
		return board;
	}
}
