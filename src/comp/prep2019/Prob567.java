package comp.prep2019;
import java.util.*;
public class Prob567 {
	public boolean checkInclusion(String s1, String s2) {
		int n;
		if((n = s1.length()) > s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (char c : s1.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        	count++;
        }
        int start = 0;
        for (int i = 0; i < s2.length(); i++) {
        	char c = s2.charAt(i);
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) - 1);
        		if (map.get(c) > -1) count--;
        	}
        	if (i - start + 1 > n) {
        		char ch = s2.charAt(start++);
        		if (map.containsKey(ch)) {
        			map.put(ch, map.get(ch) + 1);
        			if (map.get(ch) > 0) count++;
        		}
        	}
        	if (count == 0) return true;
        }
        return false;
    }
}
