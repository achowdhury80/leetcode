package com.prep2020.easy;
import java.util.*;
public class Problem2363 {
	public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1, (x, y) -> x[0] - y[0]);
        Arrays.sort(items2, (x, y) -> x[0] - y[0]);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < items1.length && j < items2.length) {
        	if (items1[i][0] == items2[j][0]) {
        		result.add(Arrays.asList(items1[i][0], items1[i][1] + items2[j][1]));
        		i++;
        		j++;
        	} else if (items1[i][0] < items2[j][0]) {
        		result.add(Arrays.asList(items1[i][0], items1[i][1]));
        		i++;
        	} else {
        		result.add(Arrays.asList(items2[j][0], items2[j][1]));
        		j++;
        	}
        }
        while(i < items1.length) {
        	result.add(Arrays.asList(items1[i][0], items1[i][1]));
    		i++;
        }
        while(j < items2.length) {
        	result.add(Arrays.asList(items2[j][0], items2[j][1]));
    		j++;
        }
        return result;
    }
}
