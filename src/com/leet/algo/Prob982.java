package com.leet.algo;
import java.util.*;
public class Prob982 {
	public int countTriplets(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;
        for (int a : A) {
        	for (int b : A) {
        		count.put(a & b, count.getOrDefault(a & b, 0) + 1);
        	}
        }
        for (int a : A) {
        	for (int key : count.keySet()) {
        		if ((a & key) == 0) result += count.get(key);
        	}
        }
        return result;
    }
}
