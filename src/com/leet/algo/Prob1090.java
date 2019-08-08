package com.leet.algo;
import java.util.*;
public class Prob1090 {
	public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
	    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
	    for (int i = 0; i < labels.length; i++) pq.offer(new int[] {labels[i], values[i]});
	    Map<Integer, Integer> usedMap = new HashMap<>();
	    int result = 0;
	    for (int i = 0; i < num_wanted && !pq.isEmpty(); i++) {
	    	int[] arr = pq.poll();
	    	if(!usedMap.containsKey(arr[0]) || usedMap.get(arr[0]) < use_limit) {
	    		usedMap.put(arr[0], usedMap.getOrDefault(arr[0], 0) + 1);
	    		result += arr[1];
	    	}
	    	else {
	    		i--;
	    	}
	    }
	    return result;
    }
	
	public static void main(String[] args) {
		Prob1090 prob = new Prob1090();
		System.out.println(prob.largestValsFromLabels(new int[] {9,8,8,7,6}, new int[] {0,0,0,1,1}, 3, 1));
	}
}
