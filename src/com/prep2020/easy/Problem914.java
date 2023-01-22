package com.prep2020.easy;
import java.util.*;
public class Problem914 {
	public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deck) map.put(d, map.getOrDefault(d, 0) + 1);
        int result = 1;
        for (int val : map.values()) {
        	if (result == 1) result = val;
        	else result = hcf(result, val);
        	if (result == 1) return false;
        }
        return true;
    }

	private int hcf(int x, int y) {
		if (y == 0) return x;
		return hcf(y, x % y);
	}
}
