package com.prep2020.hard;
import java.util.*;
public class Problem927 {
	public int[] threeEqualParts(int[] arr) {
        int count = 0, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	if (arr[i] == 1) {
        		count++;
        		map.put(count, i);
        	}
        }
        if (count == 0) return new int[] {0, n - 1};
    	if (count % 3 != 0) return new int[] {-1, -1};
    	int oneCountEach = count / 3;
    	int firstPartIndex = map.get(oneCountEach);
    	int numZerosAtEnd = 0;
    	for (int i = n - 1; i > -1; i--) {
    		if (arr[i] == 0) numZerosAtEnd++;
    		else break;
    	}
    	int secondPartIndex = map.get(2 * oneCountEach);
    	while(numZerosAtEnd > 0) {
    		firstPartIndex++;
    		secondPartIndex++;
    		if (arr[firstPartIndex] == 1 || arr[secondPartIndex] == 1) return new int[] {-1, -1};
    		numZerosAtEnd--;
    	}
    	for (int i = firstPartIndex, j = secondPartIndex, k = n - 1; oneCountEach > 0; i--, j--, k--) {
    		if (arr[i] != arr[j] || arr[j] != arr[k]) return new int[] {-1, -1};
    		if (arr[i] == 1) oneCountEach--;
    	}
    	return new int[] {firstPartIndex, secondPartIndex + 1};
    }
	
	public static void main(String[] args) {
		Problem927 problem = new Problem927();
		int[] arr = problem.threeEqualParts(new int[] {1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1});
		System.out.println(arr[0] + ", " + arr[1]);
	}
}
