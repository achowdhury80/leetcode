package comp.prep2019.less2000;
import java.util.*;
public class Prob1231 {
	
		public int maximizeSweetness(int[] sweetness, int K) {
	        int low = Integer.MAX_VALUE, high = 0;
	        for (int a : sweetness) {
	        	low = Math.min(low, a);
	        	high += a;
	        }
	        while(low < high) {
	        	int mid = low + (high - low) / 2;
	        	int friends = 0;
	        	int sumOfSweet = 0;
	        	for (int a : sweetness) {
	        		sumOfSweet += a;
	        		if (sumOfSweet > mid) {
	        			friends++;
	        			sumOfSweet = 0;
	        		}
	        	}
	        	if (friends > K) low = mid + 1;
	        	else high = mid;
	        }
	        return low;
	    }
	
	/*
	public int maximizeSweetness(int[] sweetness, int K) {
        return helper(sweetness, 0, K + 1, new HashMap<>());
    }*/
	
	private int helper(int[] sweetness, int start, int k, 
			Map<String, Integer> cache) {
        String key = start + "," + k;
        if (cache.containsKey(key)) return cache.get(key);
        int result = Integer.MIN_VALUE;
        if (k == 1) {
        	result = findSum(sweetness, start, sweetness.length - 1);
        } else {
	        for (int i = start; i <= sweetness.length - k; i++) {
	        	int sum = findSum(sweetness, start, i);
	        	int others = helper(sweetness, i + 1, k - 1, cache);
	        	int min = Math.min(sum, others);
	        	result = Math.max(result, min);
	        }
        }
        cache.put(key, result);
        return result;
    }
	
	private int findSum(int[] arr, int start, int end) {
		int result = 0;
		for (int i = start; i <= end; i++) {
    		result += arr[i];
    	}
		return result;
	}
}
