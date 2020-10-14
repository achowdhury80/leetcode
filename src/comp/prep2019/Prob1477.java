package comp.prep2019;
import java.util.*;
public class Prob1477 {
	public int minSumOfLengths(int[] arr, int target) {
        int[] minSoFar = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
        	arr[i] += (i == 0 ? 0 : arr[i - 1]);
        	map.put(arr[i], i);
        	minSoFar[i] = (i == 0 ? 0 : minSoFar[i - 1]);
        	if (map.containsKey(arr[i] - target)) {
        		int len = i - map.get(arr[i] - target);
        		minSoFar[i] = Math.min(minSoFar[i] == 0 ? Integer.MAX_VALUE 
        				: minSoFar[i], len);
        	}
        }
        map.clear();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
        	map.put(arr[i], i);
        	if (map.containsKey(arr[i] - target)) {
        		int len = i - map.get(arr[i] - target);
        		if (i - len > -1 && minSoFar[i - len] != 0) 
        			result = Math.min(result, len + minSoFar[i - len]);
        	}
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
