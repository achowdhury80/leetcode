package com.prep2020.hard;
import java.util.*;
public class Problem1326 {
	public int minTaps(int n, int[] ranges) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
        	if (ranges[i] == 0) continue;
        	list.add(new int[] {Math.max(0, i - ranges[i]), 
        			Math.min(n, i + ranges[i])});
        }
        Collections.sort(list, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        if (list.size() == 0 || list.get(0)[0] > 0) return -1;
        int[] cur = list.get(0);
        int result = 1, max = cur[1], soFar = cur[1];
        if (soFar >= n) return result;
        for (int i = 1; i < list.size(); i++) {
        	int[] next = list.get(i);
        	if (next[1] <= soFar) continue;
        	else if (next[0] <= soFar) {
        		max = Math.max(max, next[1]);
        	} else if (next[0] > soFar) {
        		if (max < next[0]) return -1;
        		result++;
        		soFar = max;
        		if (soFar >= n) return result;
        		i--;
        	}
        }
        return max == n ? result + 1 : -1;
    }
	
	public static void main(String[] args) {
		Problem1326 problem = new Problem1326();
		System.out.println(problem.minTaps(9, new int[] {0,5,0,3,3,3,1,4,0,4}));
	}
}
