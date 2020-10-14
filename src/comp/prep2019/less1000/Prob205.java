package comp.prep2019.less1000;
import java.util.*;
public class Prob205 {
	/**
	 * O(N) time and space
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char c1 = s.charAt(i), c2 = t.charAt(i);
        	if (!map.containsKey(c1) && !map.containsValue(c2)) {
        		map.put(c1, c2);
        	} else if (map.containsKey(c1) && map.get(c1) != c2) return false;
        	else if (!map.containsKey(c1) && map.containsValue(c2)) return false;
        }
        return true;
    }
}
