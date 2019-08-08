package com.leet.algo;
import java.util.*;
public class Prob1122 {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a1 : arr1) map.put(a1, map.getOrDefault(a1, 0) + 1);
        int[] result = new int[arr1.length];
        int i = 0;
        for (int k = 0; k < arr2.length; k++) {
        	for (int x = 0; x < map.get(arr2[k]); x++) {
        		result[i++] = arr2[k];
        	}
        	map.remove(arr2[k]);
        }
        int j = i;
        for (int key : map.keySet()) {
        	for (int x = 0; x < map.get(key); x++) {
        		result[i++] = key;
        	}
        }
        if(j < arr1.length - 1) Arrays.sort(result, j, arr1.length);
        return result;
    }
}
