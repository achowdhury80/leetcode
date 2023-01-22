package com.prep2020.easy;
import java.util.*;
public class Problem970 {
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if (x == 1 && y == 1) {
        	if (bound > 1) return Arrays.asList(2);
        	else return new ArrayList<>();
        }
        if (x == 1) return powerfulIntegers(y, x, bound);
        Set<Integer> result = new HashSet<>();
        List<Integer> yVals = new ArrayList<>();
        yVals.add(1);
        if (y > 1) for (long i = y; i < bound; i*= y) yVals.add((int)i);
        for (long i = 1; i < bound; i *= x) {
        	for (int j : yVals) {
        		if (i + j <= bound) result.add((int)(i + j));
        		else break;
        	}
        }
        return new ArrayList<>(result);
    }
}
