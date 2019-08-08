package com.leet.algo;

public class Prob74 {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int m = 0, n = matrix[0].length - 1;
        while (m < matrix.length && n > -1) {
        	if (matrix[m][n] == target) return true;
        	if (matrix[m][n] < target) m++;
        	else n--;
        }
        return false;
    }
	public static void main(String[] args) {
		Prob74 prob = new Prob74();
		System.out.println(prob.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 3));
	}
}
