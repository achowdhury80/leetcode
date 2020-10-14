package comp.prep2019;

import java.util.Arrays;

public class Prob870 {
	public int[] advantageCount(int[] A, int[] B) {
		Arrays.sort(A);
		Integer[] bArr = new Integer[B.length];
		for (int i = 0; i < B.length; i++) bArr[i] = i;
		Arrays.sort(bArr, (x, y) -> B[x] - B[y]);
        int[] result = new int[A.length];
        int end = B.length - 1, bArrIndex = 0;
        for (int i = 0; i < B.length; i++) {
        	if (A[i] > B[bArr[bArrIndex]]) {
        		result[bArr[bArrIndex++]] = A[i];
        	} else {
        		result[bArr[end]] = A[i];
        		end--;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob870 prob = new Prob870();
		int[] arr = prob.advantageCount(new int[] { 12,24,8,32},
				new int[] {13,25,32,11});
		System.out.println(arr);
	}
}
