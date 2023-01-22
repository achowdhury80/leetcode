package com.prep2020.hard;
import java.util.*;
public class Problem2158 {
	public int[] amountPainted(int[][] paint) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int n = paint.length;
        int[] result = new int[n];
        for (int i = 0; i < n ; i++) {
        	int total = paint[i][1] - paint[i][0];
        	int[] cur = new int[] {paint[i][0], paint[i][1]};
        	Map.Entry<Integer, Integer> floor = treeMap.floorEntry(paint[i][0]);
        	if (floor != null) {
        		if (floor.getValue() >= paint[i][1]) {
        			continue;
        		}
        		if (floor.getValue() > paint[i][0]) {
        			total -= (floor.getValue() - paint[i][0]);
        			cur[0] = floor.getKey();
        			treeMap.remove(floor.getKey());
        		}
        	}
        	Map.Entry<Integer, Integer> ceil = null;
        	while((ceil = treeMap.ceilingEntry(cur[0])) != null && ceil.getKey() < cur[1]) {
        		if (ceil.getValue() <= cur[1]) {
        			total -= (ceil.getValue() - ceil.getKey());
        			treeMap.remove(ceil.getKey());
        		} else {
        			total -= (cur[1] - ceil.getKey());
        			cur[1] = ceil.getValue();
        			treeMap.remove(ceil.getKey());
        		}
        	}
        	treeMap.put(cur[0], cur[1]);
        	result[i] = total;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2158 problem = new Problem2158();
		System.out.println(problem.amountPainted(new int[][] {{1, 4}, {5, 8}, {4, 7}}));
	}
}
