package com.prep2020.easy;

public class Problem121 {
	/**
	 * O(N)
	 * t_i0 is profit having 0 stock at hand. At the beginning t_i0 is 0
	 * t_i1 is profit after having a stock at hand. At the beginning it is not 
	 * possible. so we set it to min value
	 * t_i1 is max of existing value and t_i0 - price. Since one transaction is 
	 * allowed. t_i0 is 0 in this case.
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
        int t_i0 = 0, t_i1 = Integer.MIN_VALUE;
        for (int price : prices) {
        	t_i0 = Math.max(t_i0, t_i1 + price);
        	t_i1 = Math.max(t_i1, - price);
        }
        return t_i0;
    }
}
