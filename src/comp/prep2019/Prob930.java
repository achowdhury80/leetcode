package comp.prep2019;
import java.util.*;
public class Prob930 {
	public int numSubarraysWithSum(int[] A, int S) {
        int result = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
        	sum += A[i];
        	result += map.getOrDefault(sum - S, 0);
        	map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
