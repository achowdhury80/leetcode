package comp.prep2019;

public class Prob657 {
	/**
	 * O(N) time
	 * @param moves
	 * @return
	 */
	public boolean judgeCircle(String moves) {
        int[] changes = new int[2];
        for (char c : moves.toCharArray()) {
        	if (c == 'U') changes[0]--;
        	else if (c == 'D') changes[0]++;
        	else if (c == 'L') changes[1]--;
        	else if (c == 'R') changes[1]++;
        }
        return changes[0] == 0 && changes[1] == 0;
    }
}
