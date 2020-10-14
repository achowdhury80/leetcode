package comp.prep2019.less2000;
import java.util.*;
public class Prob1218 {
	public int longestSubsequence(int[] arr, int difference) {
        int result = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
        	int prev = arr[i] - difference;
        	if (!map.containsKey(prev)) {
        		map.put(arr[i], 1);
        	} else {
        		map.put(arr[i], map.get(prev) + 1);
        		result = Math.max(result, map.get(arr[i]));
        	}
        }
        return result;
    }
}
