package com.leet.algo;

/**
 * Created by ayanc on 12/11/17.
 */
public class Prob413 {
  public int numberOfArithmeticSlices(int[] A) {
    int length;
    if(A == null || (length = A.length) < 3) return 0;
    int result = 0;
    int cur = 0;
    for (int i = 2; i < length; i++) {
      if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
        cur++;
        result += cur;
      } else cur = 0;
    }
    return result;
  }

  public static void main(String[] arhs){
    Prob413 prob413 = new Prob413();
    System.out.println(prob413.numberOfArithmeticSlices(new int[]{1,2,3,4}));
  }
}
