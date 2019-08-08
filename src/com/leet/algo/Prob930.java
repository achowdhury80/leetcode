package com.leet.algo;
import java.util.*;;
public class Prob930 {
	public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
        	sum += A[i];
        	if (map.containsKey(sum - S))  result += map.get(sum - S);
        	map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
