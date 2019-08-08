package com.leet.algo;

public class Prob1053 {
	public int[] prevPermOpt1(int[] A) {
		int minIndex = A.length - 1;
		for (int i = A.length - 2; i > -1; i--) {
			if (A[i] <= A[minIndex]) {
				minIndex = i;
			}
			else {
				int maxIndex = minIndex;
				for (int j = i + 1; j < A.length; j++) {
					if (A[j] > A[maxIndex] && A[j] < A[i]) maxIndex = j;
				}
				int temp = A[i];
				A[i] = A[maxIndex];
				A[maxIndex] = temp;
				break;
			}
		}
		return A;
    }
	
	public static void main(String[] args) {
		Prob1053 prob = new Prob1053();
		int[] result = prob.prevPermOpt1(new int[] {3, 1, 1, 3});
		for(int i = 0; i < result.length; i++) System.out.print(result[i] + "\t");
	}
}
