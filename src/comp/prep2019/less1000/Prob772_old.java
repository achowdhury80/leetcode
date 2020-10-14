package comp.prep2019.less1000;

import java.util.HashMap;
import java.util.Map;

public class Prob772_old {
	public String minWindow(String S, String T) {
		String result = "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : T.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int start = 0, count = map.keySet().size();
        for (int i = 0; i < S.length(); i++) {
        	char c = S.charAt(i);
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) - 1);
        		if (map.get(c) == 0) count--;
        	}
        	while(count == 0) {
        		if ("".equals(result) || i - start + 1 < result.length()) 
        			result = S.substring(start, i + 1);
        		c = S.charAt(start);
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
