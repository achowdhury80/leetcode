package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 1/15/18.
 */
public class Prob542 {
  public int[][] updateMatrix(int[][] matrix) {
    int m, n;
    if(matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return matrix;
    Queue<int[]> q = new LinkedList<>();
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(matrix[i][j] == 0) q.offer(new int[]{i, j});
        else {
          matrix[i][j] = Integer.MAX_VALUE;
        }
      }
    }
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    while(!q.isEmpty()){
      int[] cell = q.poll();
      for(int[] d: dirs){
        int row = cell[0] + d[0];
        int col = cell[1] + d[1];
        if(row < 0 || col < 0 || row >= m || col >=n || matrix[row][col] <= matrix[cell[0]][cell[1]] + 1) continue;
        q.add(new int[]{row, col});
        matrix[row][col] = matrix[cell[0]][cell[1]] + 1;
      }
    }
    return matrix;
  }
}
