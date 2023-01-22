package com.prep2020.easy;
import java.util.*;
public class Problem1790 {
	public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
        	if (s1.charAt(i) != s2.charAt(i)) list.add(i);
        }
        if (list.size() == 0 || (list.size() == 2 && s1.charAt(list.get(1)) == s2.charAt(list.get(0)) 
        		&& s1.charAt(list.get(0)) == s2.charAt(list.get(1)))) return true;
        return false;
    }
}
