package comp.prep2019;
import java.util.*;
public class Prob44 {
	public boolean isMatch(String s, String p) {
		return helper(s.toCharArray(), p.toCharArray(), 0, 0, new HashMap<>());
    }
	
	private boolean helper(char[] sArr, char[] pArr, int i, int j, 
			Map<String, Boolean> cache) {
		String key = i + ":" + j;
		if (cache.containsKey(key)) return cache.get(key);
		if (i == sArr.length) {
			if (j == pArr.length) cache.put(key, true);
			else if (pArr[j] != '*') cache.put(key, false);
			else cache.put(key, helper(sArr, pArr, i, j + 1, cache));
		}
		else if (j == pArr.length && i != sArr.length) cache.put(key, false);
		else {
			if (sArr[i] == pArr[j] || pArr[j] == '?') 
				cache.put(key, helper(sArr, pArr, i + 1, j + 1, cache));
			else if (pArr[j] != '*') cache.put(key, false);
			else cache.put(key, helper(sArr, pArr, i + 1, j, cache) 
					|| helper(sArr, pArr, i, j + 1, cache));
		}
		return cache.get(key);
	}
}
