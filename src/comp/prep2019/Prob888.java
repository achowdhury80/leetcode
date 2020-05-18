package comp.prep2019;

import java.util.Arrays;

public class Prob888 {
	/**
	 * O(N)
	 * sort A, B
	 * find sum diff
	 * we need to make the move such that the difference is sum diff / 2
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] fairCandySwap(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
        int aSum = 0, bSum = 0;
        for (int a : A) aSum += a;
        for (int b : B) bSum += b;
        int diff = (aSum - bSum) / 2;
        int i = 0, j = 0;
        int[] arr = new int[2];
        while(i < A.length && j < B.length) {
        	int localDiff = A[i] - B[j];
        	if (localDiff == diff) {
        		arr[0] = A[i];
        		arr[1] = B[j];
        		break;
        	} else if (localDiff > diff) j++;
        	else i++;
        }
        return arr;
    }
}
