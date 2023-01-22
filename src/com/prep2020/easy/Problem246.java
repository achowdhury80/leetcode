package com.prep2020.easy;
import java.util.*;
public class Problem246 {
	/**
	 * O(N)
	 * @param num
	 * @return
	 */
	public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int i = 0, j = num.length() - 1;
        while(i <= j) {
        	char c = num.charAt(i);
        	if (!map.containsKey(c) || map.get(c) != num.charAt(j)) return false;
        	i++;
        	j--;
        }
        return true;
    }
}
