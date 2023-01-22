package com.prep2020.hard;
public class Problem465 {
	public int minTransfers(int[][] transactions) {
        int[] balances = new int[12];
        for (int[] t : transactions) {
        	balances[t[0]] -= t[2];
        	balances[t[1]] += t[2];
        }
        return minTransfer(0, balances);
    }

    private int minTransfer(int index, int[] balance) {
        // base case
        if (index == balance.length)
            return 0;

        // skip 0 balancce case
        if (balance[index] == 0)
            return minTransfer(index + 1, balance);

        int min = Integer.MAX_VALUE;
        for (int i = index + 1; i < balance.length; i++) {
            // opposite sign check
            if (balance[index] * balance[i] < 0) {
                balance[i] += balance[index];
                min = Math.min(min, 1 + minTransfer(index + 1, balance));

                // backtrack
                balance[i] -= balance[index];
            }
        }
        return min;
    }
}
