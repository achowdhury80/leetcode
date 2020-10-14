package comp.prep2019.less2000;

public class Prob1221 {
	/**
	 * O(N) time
	 * @param s
	 * @return
	 */
	public int balancedStringSplit(String s) {
        int result = 0;
        // L = +1 and R = -1
        int cur = 0;
        for (char c : s.toCharArray()) {
        	if (c == 'L') cur++;
        	else cur--;
        	if (cur == 0) result++;
        }
        return result;
    }
}
