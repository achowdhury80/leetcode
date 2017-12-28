package com.leet.algo;

/**
 * Created by ayanc on 12/11/17.
 */
public class Prob413 {
  public int numberOfArithmeticSlices(int[] A) {
    int length = -1;
    if(A == null || (length = A.length) == 0) return 0;
    int result = 0;
    boolean[][] ap = new boolean[length][length];
    for(int i = 0; i < length - 2; i++){
      for(int j = i + 2; j < length; j++){
        if(j - i == 2){
          ap[i][j] = isNext3InAP(A, i);
        } else if(ap[i][j - 1]){
            ap[i][j] = isNext3InAP(A, j - 2);
          }
        if(ap[i][j]) result++;
        }
      }

    return result;
  }

  public boolean isNext3InAP(int[] A, int start){
    return A[start + 2] - A[start + 1] == A[start + 1] - A[start];
  }

  public static void main(String[] arhs){
    Prob413 prob413 = new Prob413();
    System.out.println(prob413.numberOfArithmeticSlices(new int[]{1,2,3,4}));
  }
}
