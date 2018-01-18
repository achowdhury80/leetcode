package com.leet.algo;

/**
 * Created by ayanc on 1/17/18.
 */
public class Prob240 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m, n;
    if(matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return false;
    if(m == 1 && n == 1) return matrix[0][0] == target;
    return search(matrix, target, 0, m - 1, 0, n - 1);
  }

  private boolean search(int[][] matrix, int target, int startRow, int endRow, int startCol, int endCol){
    if(startRow > endRow || startCol > endCol) return false;
    if(startCol == endCol && startRow == endRow) return matrix[startRow][startCol] == target;
    int midRow = (startRow + endRow) / 2;
    int midCol = (startCol + endCol) / 2;
    if(matrix[midRow][midCol] == target) return true;
    if(matrix[midRow][midCol] > target)
      return search(matrix, target, startRow, endRow, startCol, midCol - 1)
          || search(matrix, target, startRow, midRow - 1, midCol, endCol);
    else
      return search(matrix, target, midRow + 1, endRow, startCol, endCol)
          || search(matrix, target, startRow, midRow, midCol + 1, endCol);

  }

  public static void main(String[] args){
    Prob240 prob240 = new Prob240();
    System.out.println(prob240.searchMatrix(new int[][]{{1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}}, 5));
    System.out.println(prob240.searchMatrix(new int[][]{{1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}}, 20));
  }
}
