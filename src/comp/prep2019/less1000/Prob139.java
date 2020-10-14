package comp.prep2019.less1000;
import java.util.*;
public class Prob139 {
	/**
	 * o(N^2) time and O(N) space
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> cache = new HashMap<>();
        return helper(s, 0, cache, wordDict);
    }
	
	private boolean helper(String s, int start, Map<Integer, Boolean> cache, 
			List<String> wordDict) {
		if (cache.containsKey(start)) return cache.get(start);
		if (s.length() == start) return true;
		for (String w : wordDict) {
			int idx;
			if ((idx = s.indexOf(w, start)) == start) {
				if (helper(s, start + w.length(), cache, wordDict)) {
					cache.put(start, true);
					return true;
				}
			}
		}
		cache.put(start, false);
		return false;
		
	}
	
	public static void main(String[] args) {
		Prob139 prob = new Prob139();
		System.out.println(prob.wordBreak("leetcode", Arrays.asList("leet","code")));
	}
}
