package comp.prep2019.less1000;
import java.util.*;
public class Prob294 {
	public boolean canWin(String s) {
        return helper(s,new HashMap<>());
    }
	
	private boolean helper(String s, Map<String, Boolean> cache) {
		if (cache.containsKey(s)) return cache.get(s);
		if (s.indexOf("++") < 0) {
			cache.put(s, false);
			return false;
		}
		int fromIndex = 0;
		while(fromIndex < s.length() - 1) {
			fromIndex = s.indexOf("++", fromIndex);
			if (fromIndex < 0) {
				cache.put(s, false);
				return false;
			}
			String s1 = s.substring(0, fromIndex) + "--" + s.substring(fromIndex + 2);
			if (!helper(s1, cache)) {
				cache.put(s, true);
				return true;
			}
			fromIndex++;
		}
		cache.put(s, false);
		return false;
	}
}
