package comp.prep2019.less2000;

public class Prob1128 {
	/**
	 * O(N) time and O(1) space
	 * trick is dominos number range is 1 to 9
	 * @param dominoes
	 * @return
	 */
	public int numEquivDominoPairs(int[][] dominoes) {
        int[][] dp = new int[10][10];
        // find all combinations count
        for (int[] domino : dominoes) {
        	dp[domino[0]][domino[1]]++;
        }
        int result = 0;
        /**
         * find all dp[i][j] and dp[j][i] count where i < j
         */
        for (int i = 1; i < 10; i++) {
        	for (int j = i + 1; j < 10; j++) {
        		int count = 0;
        		if (i != j) count = dp[i][j] + dp[j][i];
        		else count = dp[i][j];
        		result += count * (count - 1) / 2;
        	}
        }
        //find all dp[i][i] count
        for (int i = 1; i < 10; i++) result += dp[i][i] * (dp[i][i] - 1) / 2;
        return result;
    }
}
