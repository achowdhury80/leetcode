package comp.prep2019;
import java.util.*;
public class Prob3 {
	/**
	 * O(N) time and space
	 * sliding window and use set
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		char[] sArray = s.toCharArray();
		int cur = 0, start = -1;
		int result = 0;
		while (cur < s.length()) {
			char c = sArray[cur];
			if (set.contains(c)) {
				while (sArray[++start] != c) {
					set.remove(sArray[start]);
				}
			} else {
				set.add(c);
				result = Math.max(result, cur - start);
			}
			cur++;
		}
        return result;
    }
	
	public static void main(String[] args) {
		Prob3 prob = new Prob3();
		System.out.println(prob.lengthOfLongestSubstring("tmmzuxt"));
	}
}
