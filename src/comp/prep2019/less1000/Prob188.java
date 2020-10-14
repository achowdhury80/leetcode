package comp.prep2019.less1000;

public class Prob188 {
	/**
	 * quick solve when k >= prices.length / 2
	 * O(KD) time and space
	 * T{i][j] = max profit with at most i transactions till jth day
	 * t[0][j] = 0, t[i][0] = 0
	 * t[i][j] = math.max(t[i][j - 1], prices[j] - prices[m] + t[i - 1][m]
	 * t[i][j - 1] means no transaction on j th day
	 * or we do a transaction on jth day.
	 * In the second case, we had to buy the stock on mth day.
	 * where m can be any value from 0 to j -1
	 * we have to pick the best m where prices[j] - prices[m] + t[i - 1][m] is 
	 * maximum. here prices[j] is fixed term. 
	 * the variable term is t[i - 1][m] - prices[m]
	 * if m = 0, t[i- 1][0] = 0
	 * m= 1, t[i-1][1] - prices[1]
	 * m = 2, t[i - 1][2] - prices[2]
	 * @param k
	 * @param prices
	 * @return
	 */
	public int maxProfit(int k, int[] prices) {
		if (prices.length < 2) return 0;
		if (k >= prices.length / 2) return quickSolve(prices);
        int[][] t = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
        	int maxDiff = -prices[0];
        	for (int j = 1; j < prices.length; j++) {
        		t[i][j] = Math.max(t[i][j - 1], prices[j] + maxDiff);
        		maxDiff = Math.max(maxDiff, t[i - 1][j] - prices[j]);
        	}
        }
        return t[k][prices.length - 1];
    }
	
	private int quickSolve(int[] prices) {
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob188 prob = new Prob188();
		System.out.println(prob.maxProfit(2, new int[] {2, 4, 1}));
	}
}
