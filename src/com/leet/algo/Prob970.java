package com.leet.algo;
import java.util.*;
public class Prob970 {
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		Set<Integer> set = new HashSet<>();
		if (bound > 1) {
			int xVal = 1;
			while(xVal + 1 <= bound) {
				int yVal = 1;
				while (xVal + yVal <= bound) {
					set.add(xVal + yVal);
					if (y == 1) break;
					yVal *= y;
				}
				if (x == 1) break;
				xVal *= x;
			}
			
		}
		return new ArrayList<>(set);
    }
}
