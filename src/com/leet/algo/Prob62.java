package com.leet.algo;

/**
 * Created by ayanc on 12/13/17.
 */
public class Prob62 {
  public int uniquePaths(int m, int n) {
    if(m == 0 || n == 0) return 0;
    int[][] pathCounts = new int[m][n];
    pathCounts[m - 1][n - 1] = 1;
    for(int i = m - 1; i > -1; i--){
      for(int j = n - 1; j > -1; j--){
        if(i + 1 < m){
          pathCounts[i][j] += pathCounts[i + 1][j];
        }
        if(j + 1 < n){
          pathCounts[i][j] += pathCounts[i][j + 1];
        }
      }
    }
    return pathCounts[0][0];
  }

  public static void main(String[] args){
    Prob62 prob62 = new Prob62();
    System.out.println(prob62.uniquePaths(2, 2));
    System.out.println(prob62.uniquePaths(1, 2));
    System.out.println(prob62.uniquePaths(1, 10));
  }
}
