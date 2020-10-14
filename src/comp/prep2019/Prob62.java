package comp.prep2019;
import java.util.*;
public class Prob62 {
	/*
	 * O(mn) time and space
	 * start from end
	 * if you are at 1st row and 1st column, you have 1 path
	 */
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		Arrays.fill(dp[0], 1);
		for (int i = 0; i < m; i++) dp[i][0] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
    }
	
	public static void main(String[] args) {
		Prob62 prob = new Prob62();
		System.out.println(prob.uniquePaths(3, 2));
	}
}
