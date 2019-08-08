package com.leet.algo;

public class Prob832 {
	public int[][] flipAndInvertImage(int[][] A) {
       for (int i = 0; i < A.length; i++) {
    	   if (A[i] == null) continue;
    	   int start = 0, end = A[i].length - 1;
    	   while(start <= end) {
    		   if (start == end) A[i][start] ^= 1;
    		   else if (A[i][start] == A[i][end]) {
    			   A[i][start] ^= 1;
    			   A[i][end] ^= 1;
    		   }
    		   start++;
    		   end--;
    	   }
       }
       return A;
    }
}
