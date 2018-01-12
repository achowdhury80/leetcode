package com.leet.algo;

/**
 * Created by ayanc on 1/11/18.
 */
public class Prob396 {
  public int maxRotateFunction(int[] A) {
    if(A == null || A.length < 1) return 0;
    if(A.length == 1) return 0;
    int result = 0;

    int sum = 0;
    for(int i = 0; i < A.length; i++) sum += A[i];
    for(int i = 0; i < A.length; i++) result+= i * A[i];
    int temp = result;
    for(int i = 1; i < A.length; i++){
      temp = temp + sum - A.length * (A[A.length - i]);
      result = Math.max(result, temp);
    }
    return result;
  }

  public static void main(String[] args){
    Prob396 prob396 = new Prob396();
    System.out.println(prob396.maxRotateFunction(new int[]{4, 3, 2, 6}));
  }
}
