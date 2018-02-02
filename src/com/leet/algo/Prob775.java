package com.leet.algo;

/**
 * Created by ayanc on 1/29/18.
 */
public class Prob775 {
  public boolean isIdealPermutation(int[] A) {
    int max = A[0];
    for(int i = 2; i < A.length; i++){
      if(max > A[i]) return false;
      else max = Math.max(max, A[i - 1]);
    }
    return true;
  }

//  private int localInversion(int[] A){
//    int count = 0;
//    for(int i = 1; i < A.length; i++){
//      count += A[i - 1] > A[i] ? 1 : 0;
//    }
//    return count;
//  }
//
//  private int globalInversion(int[] A){
//    int result = 0;
//    for(int i = 1; i < A.length; i++){
//      result += findNumberOfElementsGreater(A[i], i);
//    }
//    return result;
//  }
//
//  private int findNumberOfElementsGreater(int min, int index){
//    return 0;
//  }
}
