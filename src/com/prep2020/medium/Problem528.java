package com.prep2020.medium;
import java.util.*;
public class Problem528 {
	private TreeMap<Integer, Integer> map;
	private int sum;
	private Random random;
	public Problem528(int[] w) {
        map = new TreeMap<>();
        random = new Random();
        for (int i = 0; i < w.length; i++) {
        	sum += w[i];
        	map.put(sum, i);
        }
    }
    
    public int pickIndex() {
        int val = 1 + random.nextInt(sum);
        return map.ceilingEntry(val).getValue();
    }
}
