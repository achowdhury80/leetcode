package comp.prep2019;
import java.util.*;
public class Prob290 {
	/**
	 * O(N) time and space
	 * @param pattern
	 * @param str
	 * @return
	 */
	public boolean wordPattern(String pattern, String str) {
		String[] arr = str.split(" ");
		if (arr.length != pattern.length()) return false;
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c) && !map.get(c).equals(arr[i])) return false;
			if(!map.containsKey(c) && map.containsValue(arr[i])) return false;
			map.put(c, arr[i]);
		}
		return true;
    }
}
