package com.prep2020.medium;
import java.util.*;
public class Problem1229 {
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (x, y) -> x[0] - y[0]);
        Arrays.sort(slots2, (x, y) -> x[0] - y[0]);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while(i < slots1.length && j < slots2.length) {
        	if (slots1[i][1] <= slots2[j][0]) {
        		i++;
        	} else if (slots2[j][1] <= slots1[i][0]) {
        		j++;
        	} else if (Math.max(slots1[i][0], 
        			slots2[j][0]) + duration <= Math.min(slots1[i][1], slots2[j][1])) {
        		result.add(Math.max(slots1[i][0], 
        			slots2[j][0]));
        		result.add(Math.max(slots1[i][0], 
        			slots2[j][0]) + duration);
        		return result;
        	} else if (slots1[i][1] < slots2[j][1]) {
        		i++;
        	} else if (slots1[i][1] > slots2[j][1]) {
        		j++;
        	} else {
        		i++;
        		j++;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1229 problem = new Problem1229();
		System.out.println(problem.minAvailableDuration(new int[][] {{10, 60}}, 
				new int[][] {{12, 17}, {21, 50}}, 8));
	}
}
