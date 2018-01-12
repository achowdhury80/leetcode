package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob223 {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int rect1Area = Math.abs(A - C) * Math.abs(B - D);
    int rect2Area = Math.abs(E - G) * Math.abs(F - H);
    int xIntersection = intersectionLength(A, C, E, G);
    int yIntersection = intersectionLength(B, D, F, H);
    return rect1Area + rect2Area - xIntersection * yIntersection;
  }

  private int intersectionLength(int a1, int a2, int b1, int b2){
    int[] arr = new int[]{a1, a2, b1, b2};
    Arrays.sort(arr);
    if(arr[0] == a1 && arr[1] == a2 || arr[0] == b1 && arr[1] == b2) return 0;
    return arr[2] - arr[1];
  }

  public static void main(String[] args){
    Prob223 prob223 = new Prob223();
    System.out.println(prob223.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
  }
}
