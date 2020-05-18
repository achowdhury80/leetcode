package comp.prep2019;

import java.util.HashMap;
import java.util.Map;

public class Prob454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		if(A == null || A.length == 0 || B == null || B.length == 0 || C == null 
				|| C.length == 0 || D == null || D.length == 0) return 0;
	    int n = A.length;
	    Map<Integer, Integer> abSum = new HashMap<>();
	    Map<Integer, Integer> cdSum = new HashMap<>();
	    for (int i = 0; i < n; i++) {
	    	for (int j = 0; j < n; j++) {
	    		int ab = A[i] + B[j];
	    		int cd = C[i] + D[j];
	    		abSum.put(ab, abSum.getOrDefault(ab, 0) + 1);
	    		cdSum.put(cd, cdSum.getOrDefault(cd, 0) + 1);
	    	}
	    }
	    int result = 0;
	    for (Map.Entry<Integer, Integer> entry : abSum.entrySet()) {
	    	if (cdSum.containsKey(0 - entry.getKey())) {
	    		result += entry.getValue() * cdSum.get(0 - entry.getKey());
	    	}
	    }
		return result;    
    }
}
