package comp.prep2019;

import java.util.HashMap;
import java.util.Map;

public class Prob13 {
	/**
	 * O(N)
	 * process each character and calculate previous letter value 
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap();
		map.put('I',1);
	    map.put('V', 5);
	    map.put('X', 10);
	    map.put('L', 50);
	    map.put('C', 100);
	    map.put('D', 500);
	    map.put('M', 1000);
	    char c = s.charAt(0);
	    int result = 0;
	    for (int i = 1; i < s.length(); i++) {
	    	char ch = s.charAt(i);
	    	if (map.get(c) < map.get(ch)) {
	    		result -= map.get(c);
	    	} else result += map.get(c);
	    	c = ch;
	    }
	    result += map.get(c);
	    return result;
    }
}
