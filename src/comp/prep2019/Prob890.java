package comp.prep2019;
import java.util.*;
public class Prob890 {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        char[] p = pattern.toCharArray();
        for (String w : words) {
        	if(matches(w, p)) result.add(w);
        }
        return result;
    }
	
	private boolean matches(String w, char[] p) {
		char[] arr = w.toCharArray();
		Map<Character, Character> map1 = new HashMap<>();
		Map<Character, Character> map2 = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map1.containsKey(arr[i]) && !map2.containsKey(p[i])) {
				map1.put(arr[i], p[i]);
				map2.put(p[i], arr[i]);
			} else if (map1.containsKey(arr[i]) && map2.containsKey(p[i])) {
				if (map1.get(arr[i]) != p[i]) return false;
			} else return false;
		}
		return true;
	}
}
