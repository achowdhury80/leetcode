package com.prep2020.medium;

public class Problem755 {
	public int[] pourWater(int[] heights, int volume, int k) {
		for (int i = 0; i < volume; i++) {
        	heights[k]++;
        	int cur = k;
        	boolean used = false;
        	for (int j = k - 1; j > -1; j--) {
        		if (heights[j] >= heights[cur]) break;
        		if (heights[j] < heights[cur] - 1) {
        			heights[j]++;
        			heights[cur]--;
        			used = true;
        			cur = j;
        		}
        	}
        	if (used) continue;
        	for (int j = cur + 1; j < heights.length; j++) {
        		if (heights[j] >= heights[cur]) break;
        		if (heights[j] < heights[cur] - 1) {
        			heights[j]++;
        			heights[cur]--;
        			cur = j;
        		}
        	}
		}
		return heights;
    }
}
