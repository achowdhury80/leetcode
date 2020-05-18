package comp.prep2019;
import java.util.*;
public class Prob992 {
	/**
	 * inspired from solution
	 * @param A
	 * @param K
	 * @return
	 */
	public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        int result = 0, l1 = 0, l2 = 0;
        for (int i = 0; i < A.length; i++) {
        	map1.put(A[i], map1.getOrDefault(A[i], 0) + 1);
        	map2.put(A[i], map2.getOrDefault(A[i], 0) + 1);
        	while(map1.keySet().size() > K) {
        		map1.put(A[l1], map1.get(A[l1]) - 1);
        		if (map1.get(A[l1]) == 0) map1.remove(A[l1]);
        		l1++;
        	}
        	while(map2.keySet().size() >= K) {
        		map2.put(A[l2], map2.get(A[l2]) - 1);
        		if (map2.get(A[l2]) == 0) map2.remove(A[l2]);
        		l2++;
        	}
        	result += l2 - l1;
        }
        return result;
    }
}
