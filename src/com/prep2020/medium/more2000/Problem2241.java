package com.prep2020.medium.more2000;

public class Problem2241 {
	private long[] denom = null;
	private long[] count = null;
	public Problem2241() {
		denom = new long[] {20, 50, 100, 200, 500};
		count = new long[denom.length];
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) count[i] += banknotesCount[i];
    }
    
    public int[] withdraw(int amount) {
        int[] result = new int[denom.length];
        for (int i = denom.length - 1; i > -1 && amount > 0; i--) {
        	if (denom[i] > amount || count[i] == 0) continue;
        	result[i] = (int)Math.min(amount / denom[i], count[i]);
        	amount -= denom[i] * result[i];
        }
        if (amount > 0) return new int[] {-1};
        for (int i = 0; i < denom.length; i++) count[i] -= result[i];
        return result;
    }
}
