package com.leet.algo;

public class Prob927 {
	/**
	 * o(n)
	 * find total one cound
	 * fix on rightmost portion with one count
	 * that will give trailing zero count
	 * fix the first portion with one count and trailing zeros
	 * fix the middle portaion with trailing zeros
	 * compare all  the portions for equality
	 * @param A
	 * @return
	 */
	public int[] threeEqualParts(int[] A) {
		int[] result = new int[] {-1, -1};
        int oneCount = 0;
        for (int a : A) if (a == 1) oneCount++;
        if (oneCount == 0) return new int[] { 0, 2};
        if (oneCount % 3 != 0) return result;
        int oneCountInPart = oneCount /3;
        int j = A.length - 1;
        int rightCount = 0;
        int trailingZeros = -1;
        while(rightCount < oneCountInPart) {
        	if (A[j] == 1) {
        		if(trailingZeros == -1) trailingZeros = A.length - 1 - j;
        		rightCount++;
        	}
        	j--;
        }
        j++;
        int[] firstPart = findPartition(A, trailingZeros, oneCountInPart, 0);
        if(firstPart[0] == -1) return result;
        int[] secondPart = findPartition(A, trailingZeros, oneCountInPart, firstPart[1] + 1);
        if(secondPart[0] == -1) return result;
        j = secondPart[1] + 1;
        if (compare(A, 0, secondPart[0], secondPart[1], oneCountInPart) && compare(A, secondPart[0], j, A.length - 1, oneCountInPart)) {
        	result[0] = firstPart[1]; 
        	result[1] = j;
        }
        return result;
    }
	
	private boolean compare(int[] A, int s1, int s2, int e2, int oneCount) {
		int c = 0;
		for (int i = s2 - 1, j = e2; c < oneCount; i--, j--) {
			if (A[i] != A[j]) return false;
			if (A[i] == 1) c++;
		}
		return true;
	}
	
	private int[] findPartition(int[] A, int trailingZeros, int oneCountInPart, int start) {
		int i = start;
		int[] result = new int[] {-1, -1};
        int leftCount = 0;
        while(leftCount < oneCountInPart) {
        	if (A[i] == 1) leftCount++;
        	i++;
        }
        i--;
        int c = 0;
        while( c < trailingZeros) {
        	i++;
        	if (A[i] == 1) return result;
        	c++;
        }
        return new int[] {start, i};
	}
	
	public static void main(String[] args) {
		Prob927 prob = new Prob927();
		int[] result = prob.threeEqualParts(new int[] {1,0,1,0,1});
		System.out.println(result);
	}
}
