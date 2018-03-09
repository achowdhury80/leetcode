package com.leet.algo;

/**
 * Created by ayanc on 1/17/18.
 */
public class Prob74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m, n;
    if(matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return false;
    if(m == 1 && n == 1) return matrix[0][0] == target;
    int l = 0;
    int h = m * n - 1;
    while (l < h) {
      int mid = l + (h - l) / 2;
      int r = mid / n;
      int c = mid % n;
      if (matrix[r][c] == target) return true;
      if (matrix[r][c] > target) h = mid - 1;
      else l = mid + 1;
    }
    if (l == h) return matrix[l/n][l%n] == target;
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
