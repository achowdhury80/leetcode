package comp.prep2019.less1000;
import java.util.*;
public class Prob76 {
	public String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int start = 0, count = t.length();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) - 1);
        		if (map.get(c) >= 0) count--;
        	}
        	while(count == 0) {
        		if ("".equals(result) || i - start + 1 < result.length()) 
        			result = s.substring(start, i + 1);
        		c = s.charAt(start);
        		if (map.containsKey(c)) {
        			map.put(c, map.get(c) + 1);
        			if (map.get(c) > 0) count++; 
        		}
        		start++;
        	}
        	
        }
        return result;
    }
}
