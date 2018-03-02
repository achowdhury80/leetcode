package com.leet.algo;

/**
 * Created by ayanc on 3/1/18.
 */
public class Prob308 {
  private int colSize;
  private int[] bIndexTree = null;
  private int[][] matrix;
  public Prob308(int[][] matrix) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
    colSize = matrix[0].length;
    this.matrix = matrix;
    bIndexTree = constructBIndexTree(matrix);
  }

  public void update(int row, int col, int val) {
    int incr = val - matrix[row][col];
    matrix[row][col] = val;
    increment(row, col, incr);
  }

  public void increment(int row, int col, int incr) {
    int index = findIndex(row, col);
    int next = index + 1;
    do {
      bIndexTree[next] += incr;
      next = findNext(next);
    } while (next < bIndexTree.length);
  }

  private int prefixSum(int index) {
    int sum = 0;
    int next = index + 1;
    do {
      sum += bIndexTree[next];
      next = findParent(next);
    } while (next > 0);
    return sum;
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int i = row1; i <= row2; i++) {
      int leftIndex = findIndex(i, col1);
      int rightIndex = findIndex(i, col2);
      sum += prefixSum(rightIndex) - (leftIndex == 0 ? 0 : prefixSum(leftIndex - 1));
    }
    return sum;
  }

  private int[] constructBIndexTree(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    bIndexTree = new int[m * n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        increment(i, j, matrix[i][j]);
      }
    }
    return bIndexTree;
  }

  private int findIndex(int r, int c) {
    return r * colSize + c;
  }

  private int findParent(int index) {
    return index - (index & (~index + 1));
  }

  private int findNext(int index) {
    return index + (index & (~index + 1));
  }

  public static void main(String[] args) {
    int[][] matrix;
    matrix = new int[][]{
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
    };
    Prob308 prob308 = null;
//    prob308 = new Prob308(matrix);
//    System.out.println(prob308.sumRegion(0,0,1,4));
//    System.out.println(prob308.sumRegion(2,1,4,3));
//    prob308.update(3,2,2);
//    System.out.println(prob308.sumRegion(2,1,4,3));

    matrix = new int[][]{
        {2,4},
        {-3,5}
    };
    prob308 = new Prob308(matrix);
    System.out.println(prob308.sumRegion(0,0,1,1));
    prob308.update(0,1,3);
    System.out.println(prob308.sumRegion(0,0,1,1));
    prob308.update(1,1,-3);
    System.out.println(prob308.sumRegion(0,0,1,1));
    prob308.update(0,1,1);
    System.out.println(prob308.sumRegion(0,0,1,1));

  }
}
