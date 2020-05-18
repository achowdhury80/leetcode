package comp.prep2019;

public class Prob668 {
	/**
	 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/solution/
	 * @param m
	 * @param n
	 * @param k
	 * @return
	 */
	public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
        	int mid = low + (high - low) / 2;
        	if (enough(mid, m, n, k)) high = mid;
        	else low = mid + 1;
        }
        return low;
    }
	
	private boolean enough(int x, int m, int n, int k) {
		int count = 0;
		for (int i = 1; i <= m; i++) {
			count += Math.min((x / i), n);
		}
		return count >= k;
	}
}
