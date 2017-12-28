package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 12/21/17.
 */
public class Prob688 {
  public double knightProbability(int N, int K, int r, int c) {
    if( K == 0) return 1;
    Map<int[], List<int[]>> map = new HashMap<>();
    double[][][] dp = new double[N][N][K + 1];
    Arrays.stream(dp).forEach(x -> Arrays.stream(x).forEach(y -> y[0] = 1));
    return findProbability(dp, map, N, r, c, K);
  }

  private double findProbability(double[][][] dp, Map<int[], List<int[]>> map, int N, int r, int c, int k){
    if(dp[r][c][k] != 0) return dp[r][c][k];
    List<int[]> nextMoves = findNextMoves(map, N, r, c);
    double sum = 0;
    for(int[] nextMove: nextMoves){
      sum += 0.125 * findProbability(dp, map, N, nextMove[0], nextMove[1], k - 1);
    }
    dp[r][c][k] = sum;
    return dp[r][c][k];
  }

  private List<int[]> findNextMoves(Map<int[], List<int[]>> map, int N, int r, int c){
    int[] startingPos = new int[]{r, c};
    if(map.get(startingPos) != null) return map.get(startingPos);
    List<int[]> list = new ArrayList<>();
    if(isValidPosition(N, r + 2, c + 1)) list.add(new int[]{r + 2, c + 1});
    if(isValidPosition(N, r + 2, c - 1)) list.add(new int[]{r + 2, c - 1});
    if(isValidPosition(N, r - 2, c + 1)) list.add(new int[]{r - 2, c + 1});
    if(isValidPosition(N, r - 2, c - 1)) list.add(new int[]{r - 2, c - 1});
    if(isValidPosition(N, r + 1, c + 2)) list.add(new int[]{r + 1, c + 2});
    if(isValidPosition(N, r + 1, c - 2)) list.add(new int[]{r + 1, c - 2});
    if(isValidPosition(N, r - 1, c + 2)) list.add(new int[]{r - 1, c + 2});
    if(isValidPosition(N, r - 1, c - 2)) list.add(new int[]{r - 1, c - 2});
    map.put(startingPos, list);
    return list;
  }

  private boolean isValidPosition(int N, int r, int c){
    return r > - 1 && r < N && c > -1 && c < N;
  }

  public static void main(String[] args){
    Prob688 prob688 = new Prob688();
    System.out.println(prob688.knightProbability(3, 2, 0, 0));
    System.out.println(prob688.knightProbability(8, 30, 6, 4));
  }
}
