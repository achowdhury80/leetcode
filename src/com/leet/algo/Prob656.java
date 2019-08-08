package com.leet.algo;
import java.util.*;
public class Prob656 {
	public List<Integer> cheapestJump(int[] A, int B) {
		int n = A.length;
		PathAndSum[] dp = new PathAndSum[n];
		dp[0] = new PathAndSum(Arrays.asList(new Integer[] {1}), A[0]);
		for (int i = 1; i < n; i++) {
			dp[i] = new PathAndSum(Arrays.asList(new Integer[] {i + 1}), Integer.MAX_VALUE);
			if (A[i] < 0) continue;
			for (int j = i - 1; j >= i - B && j > -1; j--) {
				if(A[j] < 0) continue;
				List<Integer> newPath = new ArrayList<>(dp[j].path);
				newPath.add((i + 1));
				PathAndSum newPathAndSum = new PathAndSum(newPath, dp[j].sum);
				if (newPathAndSum.compareTo(dp[i]) < 0) {
					dp[i] = newPathAndSum;
				} 
			}
			dp[i].sum += dp[i].sum == Integer.MAX_VALUE ? 0 : A[i];
		}
		List<Integer> result = new ArrayList<>();
		if (dp[n - 1].sum != Integer.MAX_VALUE) { 
			return dp[n - 1].path;
		}
		return result;
    }
	class PathAndSum implements Comparable<PathAndSum>{
		List<Integer> path;
		int sum;
		PathAndSum(List<Integer> path, int sum) {
			this.path = path;
			this.sum = sum;
		}
		public int compareTo(PathAndSum otherObj) {
			if (this.sum == otherObj.sum) {
				for (int i = 0; i < this.path.size(); i++) {
					if (this.path.get(i) != otherObj.path.get(i)) {
						return this.path.get(i) - otherObj.path.get(i);
					}
				}
				return 0;
			}
			return this.sum - otherObj.sum;
		}
	}
}
