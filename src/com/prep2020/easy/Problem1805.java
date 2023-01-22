package com.prep2020.easy;
import java.util.*;
public class Problem1805 {
	public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        String result = "";
        for (char c : word.toCharArray()) {
        	if (Character.isLetter(c)) {
        		if (!result.equals("")) {
        			set.add(result);
        			result = "";
        		}
        	} else {
        		if (result.equals("")) result = "0";
        		if (c == '0' && result.equals("0")) continue;
        		result += c;
        	}
        }
        if (!result.equals("")) set.add(result);
        return set.size();
    }
}