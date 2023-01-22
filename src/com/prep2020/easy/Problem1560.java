package com.prep2020.easy;
import java.util.*;
public class Problem1560 {
	public List<Integer> mostVisited(int n, int[] rounds) {
        int[] arr = new int[n + 1];
        arr[rounds[0]]++;
        for (int i = 0; i < rounds.length - 1; i++) {
        	for (int j = (rounds[i] + 1) % (n + 1); ; j = (j + 1) % (n + 1)) {
        		if (j == 0) j = 1;
        		arr[j]++;
        		if (j == rounds[i + 1]) break;
        	}
        }
        List<Integer> result = new ArrayList<>();
        int count = -1;
        for (int i = 1; i < arr.length; i++) {
        	if (arr[i] > count) {
        		count = arr[i];
        		result.clear();
        		result.add(i);
        	} else if (arr[i] == count) {
        		result.add(i);
        	}
        }
        Collections.sort(result);
        return result;
    }
}
