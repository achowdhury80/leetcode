package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob891 {
	/**
	 * https://leetcode.com/problems/sum-of-subsequence-widths/solution/
	 * not worth
	 * @param A
	 * @return
	 */
	public int sumSubseqWidths(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; ++i)
            pow2[i] = pow2[i-1] * 2 % MOD;

        long ans = 0;
        for (int i = 0; i < N; ++i)
            ans = (ans + (pow2[i] - pow2[N-1-i]) * A[i]) % MOD;

        return (int) ans;
    }
}
