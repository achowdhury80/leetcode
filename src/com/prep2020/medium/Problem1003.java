package com.prep2020.medium;
import java.util.*;
public class Problem1003 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
        	list.add(c);
        	if (list.size() > 2 && c == 'c' && list.get(list.size() - 2) == 'b'
        			&& list.get(list.size() - 3) == 'a') {
        		list.remove(list.size() - 1);
        		list.remove(list.size() - 1);
        		list.remove(list.size() - 1);
        	}
        }
        return list.isEmpty();
    }
}
