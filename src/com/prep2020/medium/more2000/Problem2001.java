package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2001 {
	public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();
        for (int[] rect : rectangles) {
        	double ratio = (rect[0] + 0.) / (rect[1] + 0.);
        	map.put(ratio, map.getOrDefault(ratio, 0l) + 1l);
        }
        long result = 0l;
        for (long val : map.values()) {
        	if (val > 1) result += (val * (val - 1)) / 2;
        }
        return result;
    }
}
