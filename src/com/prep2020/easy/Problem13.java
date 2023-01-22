package com.prep2020.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem13 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I',1);
	    map.put('V', 5);
	    map.put('X', 10);
	    map.put('L', 50);
	    map.put('C', 100);
	    map.put('D', 500);
	    map.put('M', 1000);
	    char last = s.charAt(0);
	    int result = 0;
	    for (int i = 1; i < s.length(); i++) {
	    	char c = s.charAt(i);
	    	if (map.get(last) < map.get(c)) result -= map.get(last);
	    	else result += map.get(last);
	    	last = c;
	    }
	    return result + map.get(last);
    }
}
