package com.prep2020.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	    if(A == null || A.length == 0 || B == null || B.length == 0 || C == null || C.length == 0 || D == null
	        || D.length == 0) return 0;
	    int n = A.length;
	    Map<Long, Integer> abSum = new HashMap<>();
	    Map<Long, Integer> cdSum = new HashMap<>();
	    for(int i = 0; i < n; i++)
	      for(int j = 0; j < n; j++) {
	        long sum = A[i] + B[j];
	        abSum.put(sum, abSum.getOrDefault(sum, 0) + 1);
	      }

	    for(int i = 0; i < n; i++)
	      for(int j = 0; j < n; j++) {
	        long sum = C[i] + D[j];
	        cdSum.put(sum, cdSum.getOrDefault(sum, 0) + 1);
	      }
	    int result = 0;
	    for(long key : abSum.keySet()){
	      if(cdSum.containsKey(0 - key)){
	        result += abSum.get(key) * cdSum.get(0 - key);
	      }
	    }
	    return result;
	  }
}
