package com.prep2020.medium;

public class Problem790 {
	/**
	 * https://leetcode.com/problems/domino-and-tromino-tiling/discuss/116664/Schematic-explanation-of-two-equivalent-DP-recurrence-formula
	 * @param N
	 * @return
	 */
	public int numTilings(int N) {
        int mod = (int)(1e9 + 7);
        if (N < 2) return N;
        int t_pre = 1, t_prepre = 1, t_up_pre = 0, t_down_pre = 0;
        for (int i = 2; i <= N; i++) {
        	int t_cur = (int)((0l + t_pre + t_prepre + t_up_pre + t_down_pre) % mod);
        	int t_up = (int)((0l + t_prepre + t_down_pre) % mod);
        	int t_down = (int)((0l + t_prepre + t_up_pre) % mod);
        	t_prepre = t_pre;
        	t_pre = t_cur;
        	t_up_pre = t_up;
        	t_down_pre = t_down;
        }
        return t_pre;
    }
}
