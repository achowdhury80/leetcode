package com.leet.algo;
import java.util.*;
public class Prob497 {
	private TreeMap<Integer, Integer> treeMap;
	private int sum;
	private Random random;
	private int[][] rects;
	public Prob497(int[][] rects) {
		this.rects = rects;
		random = new Random();
		treeMap = new TreeMap<>();
		sum = 0;
        for (int i = 0; i < rects.length; i++) {
        	int area = (Math.abs(rects[i][0] - rects[i][2]) + 1)
        			* (Math.abs(rects[i][1] - rects[i][3]) + 1);
        	sum += area;
        	treeMap.put(sum, i);
        }
    }
    
    public int[] pick() {
        int area = random.nextInt(sum);
        int rectIdx = treeMap.higherEntry(area).getValue();
        int[] rect = rects[rectIdx];
        int xRandom = rect[0] + random.nextInt(1 + Math.abs(rect[2] - rect[0]));
        int yRandom = rect[1] + random.nextInt(1 + Math.abs(rect[3] - rect[1]));
        return new int[] {xRandom, yRandom};
    }
}
