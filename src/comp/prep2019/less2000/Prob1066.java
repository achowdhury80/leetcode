package comp.prep2019.less2000;
import java.util.*;
public class Prob1066 {
	/**
	 * if we used 1st, 3rd, 7th bike, used will be 001001010
use used to avoid to use same bike and record this state to Pruning
	 * @param workers
	 * @param bikes
	 * @return
	 */
	public int assignBikes(int[][] workers, int[][] bikes) {
        int[] dp = new int[1 << bikes.length];
        return dfs(workers, 0, bikes, dp, 0);
    }
	
	private int dfs(int[][] workers, int wid, int[][] bikes, int[] dp, int used) {
		if (wid >= workers.length) return 0;
		if(dp[used] > 0) return dp[used];
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < bikes.length; i++) {
			if ((used & (1 << i)) != 0) continue;
			result = Math.min(result, Math.abs(workers[wid][0] - bikes[i][0]) + Math.abs(workers[wid][1] - bikes[i][1])
				+ dfs(workers, wid + 1, bikes, dp, used | (1 << i)));
		}
		dp[used] = result;
		return dp[used];
	}
}
