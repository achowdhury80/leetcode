package com.prep2020.easy;
import java.util.*;
public class Problem771 {
	/**
	 * let n1 = J.length
	 * n2 = S.length
	 * O(n1 + n2) time
	 * and O(n1) space
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char c : J.toCharArray()) jewels.add(c);
        int result = 0;
        for (char c : S.toCharArray()) if (jewels.contains(c)) result++;
        return result;
    }
}
