package com.leet.algo;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob764 {
  public int orderOfLargestPlusSign(int N, int[][] mines) {
    if(N * N <= mines.length) return 0;
    int maxWing = 0;
    int[][][] wingMap = new int[N][N][4];
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        wingMap[i][j][0] = j;
        wingMap[i][j][1] = i;
        wingMap[i][j][2] = N - j - 1;
        wingMap[i][j][3] = N - i - 1;
      }
    }

    for(int i = 0; i < mines.length; i++){
      int mx = mines[i][0];
      int my = mines[i][1];
      for(int x = 0; x < 4; x++) wingMap[mx][my][x] = 0;
      for(int j = my + 1; j < N; j++){
        if(wingMap[mx][j][0] == 0)
        wingMap[mx][j][0] = j;
      }
    }
    return 0;
  }


}
