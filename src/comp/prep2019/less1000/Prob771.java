package comp.prep2019.less1000;
import java.util.*;
public class Prob771 {
	/**
	 * O(m + n) time and o(m) space
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) set.add(c);
        int result = 0;
        for (char c : S.toCharArray()) {
        	if (set.contains(c)) result++;
        }
        return result;
    }
}
