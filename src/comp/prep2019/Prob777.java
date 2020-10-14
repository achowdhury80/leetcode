package comp.prep2019;


public class Prob777 {
	/**
	 * https://leetcode.com/problems/swap-adjacent-in-lr-string/solution/
	 * O(N) and O(1)
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean canTransform(String start, String end) {
		if (!start.replaceAll("X", "").equals(end.replaceAll("X", ""))) return false;
		int t = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) == 'L') {
				while(end.charAt(t) != 'L') t++;
				if (t++ > i) return false;
			}
		}
		t = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) == 'R') {
				while(end.charAt(t) != 'R') t++;
				if (t++ < i) return false;
			}
		}
		return true;
	}
}
