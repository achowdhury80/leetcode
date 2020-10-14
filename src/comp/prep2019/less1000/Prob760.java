package comp.prep2019.less1000;
import java.util.*;
public class Prob760 {
	/**
	 * O(N) time and space
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
        	List<Integer> list = map.getOrDefault(B[i], new ArrayList<>());
        	list.add(i);
        	map.put(B[i], list);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
        	List<Integer> list = map.get(A[i]);
        	int j = list.remove(0);
        	result[i] = j;
        }
        return result;
    }
}
