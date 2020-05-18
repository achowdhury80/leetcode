package comp.prep2019;

public class Prob1105 {
	/**
	 * O(N * w) where w - is shelf width
	 * 
	 * @param books
	 * @param shelf_width
	 * @return
	 */
	public int minHeightShelves(int[][] books, int shelf_width) {
		// dp[i] is the maxheight till ith book.. no matter how many rows we use
        int[] dp = new int[books.length];
        for (int i = 0; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = books[0][1];
        /**
         * for each book try all cases - taking the book itself only
         * taking one more book from left so on until the sum of width is less than shelf width
         */
        for (int i = 1; i < books.length; i++) {
        	int runningWidth = 0, maxHeight = 0;
        	for (int j = i; j > -1; j--) {
        		runningWidth += books[j][0];
        		if (runningWidth > shelf_width) break;
        		maxHeight = Math.max(maxHeight, books[j][1]);
        		dp[i] = Math.min(dp[i], maxHeight + (j > 0 ? dp[j - 1]: 0));
        	}
        }
        return dp[dp.length - 1];
    }
}
