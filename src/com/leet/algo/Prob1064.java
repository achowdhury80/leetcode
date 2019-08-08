package com.leet.algo;

public class Prob1064 {
	public int fixedPoint(int[] A) {
        int start = 0, end = A.length - 1;
        int result = -1;
        while(start <= end) {
        	int mid = start + (end - start) / 2;
        	if (A[mid] == mid) {
        		result = mid;
        		end = mid - 1;
        	} else if(A[mid] < mid) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1064 prob = new Prob1064();
		System.out.println(prob.fixedPoint(new int[] {-10,-5,0,3,7}));
		System.out.println(prob.fixedPoint(new int[] {-1,0,1,2,3,4,5,7,9,10,11,12,13,14}));
	}
}
