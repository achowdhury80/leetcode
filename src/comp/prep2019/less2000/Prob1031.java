package comp.prep2019.less2000;

public class Prob1031 {
	public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sum = new int[A.length], reverseSum = new int[A.length];
        sum[0] = A[0];
        reverseSum[A.length - 1] = A[A.length - 1];
        // mSum[i][0] is the max sum of m continuous elements from 0th to ith element
        // mSum[i][1] is the max sum of m continuous elements from ith to last element
        int[][] mSum = new int[A.length][2];
        if (M == 1) {
        	mSum[0][0] = sum[0];
        	mSum[A.length - 1][1] = reverseSum[A.length - 1];
        }
        for (int i = 1; i < A.length; i++) {
        	sum[i] = sum[i - 1] + A[i];
        	reverseSum[A.length - i - 1] = reverseSum[A.length - i] + A[A.length - i - 1];
        	if (i == M - 1) {
        		mSum[i][0] = sum[i];
        		mSum[A.length - i - 1][1] = reverseSum[A.length - i - 1];
        	} else if (i >= M) {
        		mSum[i][0] = Math.max(mSum[i - 1][0], sum[i] - sum[i - M]);
        		mSum[A.length - i - 1][1] = Math.max(mSum[A.length - i][1], reverseSum[A.length - i - 1] - reverseSum[A.length - i - 1 + M]);
        	}
        }
        int result = 0;
        for (int i = L - 1; i < A.length; i++) {
        	int mMax = Math.max((i < L + M - 1 ? 0 : mSum[i - L][0]), (i + M <= A.length - 1 ? mSum[i + 1][1] : 0));
        	result = Math.max(result, sum[i] - (i < L ? 0 : sum[i - L]) + mMax);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1031 prob = new Prob1031();
		System.out.println(prob.maxSumTwoNoOverlap(new int[] {1, 0, 1}, 1, 1));
	}
}
