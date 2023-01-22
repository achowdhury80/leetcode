package com.prep2020.easy;
import java.util.*;
public class Problem1876 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int countGoodSubstrings(String s) {
		if (s.length() < 3) return 0;
        int result = 0;
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        list.add(s.charAt(1));
        list.add(s.charAt(2));
        if (list.get(0) != list.get(1) && list.get(0) != list.get(2)
        		&& list.get(1) != list.get(2)) result++;
        for (int i = 3; i < s.length(); i++) {
        	list.add(s.charAt(i));
        	list.remove(0);
        	if (list.get(0) != list.get(1) && list.get(0) != list.get(2)
            		&& list.get(1) != list.get(2)) result++;
        }
        return result;
    }
}
