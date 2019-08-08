package com.leet.algo;

public class Prob691 {
	/**
	 * Time Complexity: O(2^T * S * T) where S be the total number of letters in all stickers, and T be the number of letters in the target word. We can examine each loop carefully to arrive at this conclusion.
		Space Complexity: O(2^T)the space used by dp.
		Suppose we need dp[state] stickers to satisfy all target[i]'s for which the i-th bit of state is set. We would like to know dp[(1 << len(target)) - 1].
		
	 * @param stickers
	 * @param target
	 * @return
	 */
	public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[] dp = new int[1 << n];
        // set all complete or partially set state dp value to -1
        for (int i = 1; i < dp.length; i++) dp[i] = -1;
        //start with state 0. that is nothing is set.
        for (int state = 0; state < dp.length - 2; state++) {
        	if (dp[state] == -1) continue;
        	//for each sticker and each bit position check if a new unset bit can be set. if yes, you get a new state. update dp accordingly
        	for (String sticker : stickers) {
        		int now = state;
        		for (char c : sticker.toCharArray()) {
        			for (int i = 0; i < n; i++) {
        				if (((now >> i) & 1) == 1 || c != target.charAt(i)) continue;
        				now |= (1 << i);
        				break;
        			}
        		}
        		if (dp[now] == -1 || dp[now] > dp[state] + 1) dp[now] = dp[state] + 1;
        	}
        }
        return dp[(1 << n) - 1];
    }
}
