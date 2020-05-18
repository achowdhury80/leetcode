package comp.prep2019;

public class Prob309 {
	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems
	 * @param prices
	 * @return
	 */
	// T[i][k][0] = Math.max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
	// T[i][k][1] = Math.max(T[i - 1][k][1], T[i - 2][k - 1][0] - prices[i])
	public int maxProfit(int[] prices) {
        int ti0 = 0, ti1 = Integer.MIN_VALUE, ti0_pre = 0;
        for (int price : prices) {
        	int temp = ti0;
        	ti0 = Math.max(ti0, ti1 + price);
        	ti1 = Math.max(ti1, ti0_pre - price);
        	ti0_pre = temp;
        }
        return ti0;
    }
}
