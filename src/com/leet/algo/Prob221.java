package com.leet.algo;

/**
 * Created by ayanc on 12/25/17.
 */
public class Prob221 {
  public int maximalSquare(char[][] matrix) {
    int m, n;
    if(matrix == null || (m = matrix.length) == 0 || (n = matrix[0].length) == 0) return 0;
    int maxSquareSize = m > n ? n : m;
    int[][][] dp = new int[m + 1][n + 1][maxSquareSize + 1];
    int result = 0;
    for(int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j][1] = matrix[i - 1][j - 1] == '1' ? 1 : 0;
        if(dp[i][j][1] == 1) result = Math.max(result, 1);
      }
    }
    for(int k = 2; k <= maxSquareSize; k++){
      for(int i = 1; i <= m; i++){
        for(int j = 1; j <= n; j++){
          if(dp[i][j][1] == 0) continue;
          if(i + k > m + 1 || j + k > n + 1) continue;
//          if(i + k > maxSquareSize + 1) {
//            dp[i][j][k] = 0;
//            continue;
//          }
          if(dp[i + 1][j + 1][k - 1] == 0){
            dp[i][j][k] = 0;
            continue;
          }
          boolean flag = true;
          for(int x = i + 1; x <= i + k - 1; x++){
            if(dp[x][j][1] == 0){
              dp[i][j][k] = 0;
              flag = false;
              break;
            }
          }
          if(flag) {
            for (int y = j + 1; y <= j + k - 1; y++) {
              if (dp[i][y][1] == 0) {
                dp[i][j][k] = 0;
                flag = false;
                break;
              }
            }
          }
          if(flag){
            dp[i][j][k] = 1;
            result = Math.max(result, k);
          } else {
            dp[i][j][k] = 0;
          }
        }
      }
    }

    return result * result;
  }

  public static void main(String[] args){
    Prob221 prob221 = new Prob221();
//    System.out.println(prob221.maximalSquare(new char[][]{{'1','0','1','0','0'},
//        {'1','0','1','1','1'},
//        {'1','1','1','1','1'},
//        {'1','0','0','1','0'}}));
    //System.out.println(prob221.maximalSquare(new char[][]{{'1'}}));
    System.out.println(prob221.maximalSquare(new char[][]{{'1','1','0','1'},{'1','1','0','1'},{'1','1','1','1'}}));
  }
}
