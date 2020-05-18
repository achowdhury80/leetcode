package comp.prep2019;
import java.util.*;
public class Prob1216 {
	
	public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        if (k >= n - 1) return true;
        int d = helper(s, 0, n - 1, new HashMap<String, Integer>());
        return d <= k;
    }
	/**
	 * find number of chars to be deleted
	 * @param s
	 * @param start
	 * @param end
	 * @param cache
	 * @return
	 */
	private int helper(String s, int start, int end, 
			Map<String, Integer> cache) {
		if (start >= end) return 0;
		String key = start + "#" + end;
		if (!cache.containsKey(key)) {
			if (s.charAt(start) == s.charAt(end)) {
				cache.put(key, helper(s, start + 1, end - 1, cache));
			} else {
				cache.put(key, 1 + Math.min(
						helper(s, start + 1, end, cache), 
						helper(s, start, end - 1, cache)));
			}
		}
		return cache.get(key);
	}
}
