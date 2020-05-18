package comp.prep2019;
import java.util.*;
public class Prob823 {
	/**
	 * O(n^2) time and O(n) space
	 * @param A
	 * @return
	 */
	public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        // single node trees
        for (int i : A) map.put(i, 1);
        int mod = (int)(1e9 + 7);
        for (int i = 1; i < A.length; i++) {
        	//for each number try any two smaller number product
        	// multiply their variation
        	for (int j = 0; j < i; j++) {
        		int div;
        		if (A[i] % A[j] == 0 && map.containsKey((div = A[i]/A[j]))) {
        			long toAdd = (1l * map.get(A[j]) * map.get(div)) % mod;
        			map.put(A[i], (int)((map.get(A[i]) + toAdd) % mod));
        		}
        	}
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	result = (int)((0l + result + entry.getValue()) % mod);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob823 prob = new Prob823();
		System.out.println(prob.numFactoredBinaryTrees(new int[] {2, 4, 5, 10}));
	}
}
