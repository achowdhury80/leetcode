package comp.prep2019;

public class Prob942 {
	/**
	 * O(N)
	 * track two counters for max and min
	 * if d then add max else add min
	 * @param S
	 * @return
	 */
	public int[] diStringMatch(String S) {
        int min = 0, max = S.length();
        int[] result = new int[S.length() + 1];
        int i = 0;
        for (char c : S.toCharArray()) {
        	if (c == 'D') result[i++] = max--;
        	else result[i++] = min++;
        }
        result[i] = min;
        return result;
    }
}
