package com.leet.algo;

import java.util.Arrays;

public class Prob1040 {
	// intution, once moved all will be in the sliding window of length
	public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        /*
         * We try to move all stones to leftmost or rightmost.
For example of to rightmost.
We move the A[0] to A[1] + 1.
Then each time, we pick the stone of left endpoint, move it to the next empty position.
During this process, the position of leftmost stones increment 1 by 1 each time.
Until the leftmost is at A[n - 1] - n + 1.
         */
        int max = Math.max(stones[n - 1] - n + 2 - stones[1], stones[n - 2] - stones[0] - n + 2);
        int i = 0;
        int low = n;
        /*
         * in case of n stones,
we need to find a consecutive n positions and move the stones in.

This idea led the solution with sliding windows.

Slide a window of size N, and find how many stones are already in this window.
We want moves other stones into this window.
For each missing stone, we need at least one move.

Generally, the number of missing stones and the moves we need are the same.
Only one corner case in this problem, we need to move the endpoint to no endpoint.

For case 1,2,4,5,10,
1 move needed from 10 to 3.

For case 1,2,3,4,10,
2 move needed from 1 to 6, then from 10 to 5.

         */
        for (int j = 0; j < n; j++) {
        	while(stones[j] - stones[i] >= n) i++;
        	if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) low = Math.min(low, 2);
        	else low = Math.min(low, n - (j - i + 1));
        }
        return new int[] {low, max};
    }
}
