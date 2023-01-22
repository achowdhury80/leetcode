package com.prep2020.medium.more2000;

public class Problem2043 {
	private long[] balance;
	public Problem2043(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 1 || account2 < 1 || account1 > balance.length 
        		|| account2 > balance.length) return false;
        if (balance[account1 - 1] < money) return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
    	if (account < 1 || account > balance.length) return false;
    	balance[account - 1] += money;
    	return true;
    }
    
    public boolean withdraw(int account, long money) {
    	if (account < 1 || account > balance.length 
    			|| balance[account - 1] < money) return false;
    	balance[account - 1] -= money;
    	return true;
    }
}
