package com.prep2020.medium;
import java.util.*;
public class Problem497 {
	private int[][] rects;
	private TreeMap<Integer, Integer> treeMap;
	private int total;
	private Random random;
	public Problem497(int[][] rects) {
        this.rects = rects;
        treeMap = new TreeMap<>();
        for (int i = 0; i < rects.length; i++) {
        	treeMap.put(total, i);
        	int area = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
        	total += area;
        }
        random = new Random();
    }
    
    public int[] pick() {
        int r = random.nextInt(total);
        int idx = treeMap.floorEntry(r).getValue();
        int[] xy = rects[idx];
        return new int[] {xy[0] + random.nextInt(xy[2] - xy[0] + 1), xy[1] + random.nextInt(xy[3] - xy[1] + 1)};
    }
}
