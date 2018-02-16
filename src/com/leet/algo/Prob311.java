package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/15/18.
 */
public class Prob311 {
  public int[][] multiply(int[][] A, int[][] B) {
    int m = A.length;
    int n = A[0].length;
    int nB = B[0].length;
    List<Integer>[] indexA = new List[m];
    int[][] result = new int[m][nB];
    for (int i = 0; i < m; i++) {
      indexA[i] = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if (A[i][j] != 0) {
          indexA[i].add(j);
          indexA[i].add(A[i][j]);
        }
      }
    }

    for (int i = 0; i < m; i ++) {
      List<Integer> numsA = indexA[i];
      for (int j = 0; j < numsA.size(); j += 2) {
        int colA = numsA.get(j);
        int valA = numsA.get(j + 1);
        for (int k = 0; k < nB; k++) {
          result[i][k] += valA * B[colA][k];
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob311 prob311 = new Prob311();
  }
}
