package com.prep2020.medium;

import java.util.Arrays;

public class Problem1465 {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxWidth = Integer.MIN_VALUE;
        int start = 0;
        for (int v : verticalCuts) {
        	maxWidth = Math.max(maxWidth, v - start);
        	start = v;
        }
        maxWidth = Math.max(maxWidth, w - verticalCuts[verticalCuts.length - 1]);
        
        int maxHeight = Integer.MIN_VALUE;
        start = 0;
        for (int ht : horizontalCuts) {
        	maxHeight = Math.max(maxHeight, ht - start);
        	start = ht;
        }
        maxHeight = Math.max(maxHeight, h - horizontalCuts[horizontalCuts.length - 1]);
        
        long mod = (long)(1e9 + 7);
        return (int)(((1l * maxWidth) * (1l * maxHeight)) % mod);
    }
}
