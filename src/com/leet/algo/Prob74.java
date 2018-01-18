package com.leet.algo;

/**
 * Created by ayanc on 1/17/18.
 */
public class Prob74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m, n;
    if(matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return false;
    if(m == 1 && n == 1) return matrix[0][0] == target;
    int startRow = 0, endRow = m - 1;
    while (startRow < endRow){
      int midRow = (startRow + endRow) / 2;
      if(matrix[midRow][0] == target) return true;
      if(matrix[midRow][0] < target){
        startRow = midRow;
        if(matrix[midRow + 1][0] == target) return true;
        if(matrix[midRow + 1][0] < target) startRow = midRow + 1;
        else endRow = midRow;
      } else {
        endRow = midRow - 1;
      }
    }
    if(endRow >= m || startRow < 0) return false;
    int startCol = 0, endCol = n - 1;
    while(startCol < endCol){
      int midCol = (startCol + endCol) / 2;
      if(matrix[startRow][midCol] == target) return true;
      if(matrix[startRow][midCol] < target){
        startCol = midCol + 1;
      } else {
        endCol = midCol - 1;
      }
    }
    if(startCol == endCol && matrix[startRow][startCol] == target) return true;
    return false;

  }

  public static void main(String[] args){
    Prob74 prob74 = new Prob74();
    int[][] matrix = new int[][]{
        {1,   3,  5,  7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };
    System.out.println(prob74.searchMatrix(matrix, 3));
    System.out.println(prob74.searchMatrix(matrix, 51));
    System.out.println(prob74.searchMatrix(matrix, 0));
    System.out.println(prob74.searchMatrix(matrix, 1));
    System.out.println(prob74.searchMatrix(matrix, 50));
    System.out.println(prob74.searchMatrix(matrix, 16));
    System.out.println(prob74.searchMatrix(matrix, 17));
  }
}
