package com.leet.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 12/8/17.
 */
public class Prob454 {
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

  public static void main(String[] args){
    Prob454 prob454 = new Prob454();
    int [] A = new int[]{1, 2};
    int [] B = new int[]{-2,-1};
    int [] C = new int[]{-1, 2};
    int [] D = new int[]{ 0, 2};
    System.out.println(prob454.fourSumCount(A, B, C, D));
  }
}
