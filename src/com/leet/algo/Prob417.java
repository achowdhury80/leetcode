package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 1/15/18.
 */
public class Prob417 {
  public List<int[]> pacificAtlantic(int[][] matrix) {
    int m, n;
    List<int[]> result = new ArrayList<>();
    if(matrix == null || (m = matrix.length) == 0 || (n = matrix[0].length) == 0) return result;
    boolean[][] pGrid = new boolean[m][n];
    boolean[][] aGrid = new boolean[m][n];
    Set<CoOrdinate> pExplored = new HashSet<>();
    Set<CoOrdinate> aExplored = new HashSet<>();
    Queue<int[]> pQ = new LinkedList<>();
    Queue<int[]> aQ = new LinkedList<>();
    int[] temp = new int[2];
    for(int i = 0; i < m; i++) {
      pGrid[i][0] = true;
      temp = new int[]{i, 0};
      pQ.add(temp);
      pExplored.add(new CoOrdinate(temp));
      aGrid[i][n - 1] = true;
      temp = new int[]{i, n - 1};
      aQ.add(temp);
      aExplored.add(new CoOrdinate(temp));
    }
    for(int i = 0; i < n; i++) {
      if(i != 0) {
        pGrid[0][i] = true;
        temp = new int[]{0, i};
        pQ.add(temp);
        pExplored.add(new CoOrdinate(temp));
      }
      if(i != n - 1) {
        aGrid[m - 1][i] = true;
        temp = new int[]{m - 1, i};
        aQ.add(temp);
        aExplored.add(new CoOrdinate(temp));
      }
    }
    bfs(matrix, pGrid, pQ, pExplored, m, n);
    bfs(matrix, aGrid, aQ, aExplored, m, n);
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(pGrid[i][j] && aGrid[i][j]) result.add(new int[]{i, j});
      }
    }
    return result;

  }

  private void adjust(int[][] matrix, boolean[][] grid, Queue<int[]> q, int[][] neighbor, Set<CoOrdinate> explored,
                    int m, int n, int height){
    for(int i = 0; i < 4; i++){
      if(neighbor[i][0] < 0 || neighbor[i][0] >= m || neighbor[i][1] < 0 || neighbor[i][1] >= n) continue;
      CoOrdinate coOrdinate = new CoOrdinate(neighbor[i]);
      if(!explored.contains(coOrdinate)){
        if(matrix[neighbor[i][0]][neighbor[i][1]] >= height) {
          grid[neighbor[i][0]][neighbor[i][1]] = true;
          q.add(neighbor[i]);
        }
      }
    }
  }

  private void bfs(int[][] matrix, boolean[][] grid, Queue<int[]> q, Set<CoOrdinate> explored, int m, int n){
    while(!q.isEmpty()){
      int[] cell = q.poll();
      explored.add(new CoOrdinate(cell));
      int height = matrix[cell[0]][cell[1]];
      adjust(matrix, grid, q, new int[][]{{cell[0] - 1, cell[1]}, {cell[0] + 1, cell[1]}, {cell[0], cell[1] - 1},
          {cell[0], cell[1] + 1}}, explored, m, n, height);
    }

  }

  class CoOrdinate{
    int x, y;

    public CoOrdinate(int[] arr) {
      this.x = arr[0];
      this.y = arr[1];
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      CoOrdinate that = (CoOrdinate) o;

      if (x != that.x) return false;
      return y == that.y;

    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }
  }

  public static void main(String[] args){
    Prob417 prob417 = new Prob417();
    List<int[]> result = prob417.pacificAtlantic(new int[][] {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    });
    result.forEach(x -> System.out.print("[" + x[0] + ", " + x[1] +"], "));
  }
}
