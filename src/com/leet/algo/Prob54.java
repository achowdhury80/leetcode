package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/23/18.
 */
public class Prob54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    int m, n;
    List<Integer> result = new ArrayList<>();
    if(matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return result;
    if(m == 1 && n == 1){
      result.add(matrix[0][0]);
      return result;
    }
    int r = -1;
    int c = -1;
    boolean[] direction = new boolean[4];
    while(m > 0 && n > 0){
      direction[0] = true;
      r++;
      c++;
      int startR = r;
      int startC = c;
      int size = (m == 1 || n == 1) ? m * n : (m * n - (m - 2) * (n - 2));
      for(int i = 0; i < size; i++){
        result.add(matrix[r][c]);
        if(direction[0]){
          if(c == startC + n - 1){
            direction[0] = false;
            direction[1] = true;
            r++;
          } else {
            c++;
          }
        } else if(direction[1]){
          if(r == startR + m - 1){
            direction[1] = false;
            direction[2] = true;
            c--;
          } else {
            r++;
          }
        } else if(direction[2]){
          if(c == startC){
            direction[2] = false;
            direction[3] = true;
            r--;
          } else {
            c--;
          }
        } else if(direction[3]){
          r--;
        }

      }
      m = m - 2;
      n = n - 2;
    }
    return result;
  }

  public static void main(String[] args){
    Prob54 prob54 = new Prob54();
    System.out.println(prob54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9 }}));
  }
}
