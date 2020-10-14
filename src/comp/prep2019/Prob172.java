package comp.prep2019;

public class Prob172 {
	/**
	 * O(logn)
	 * @param n
	 * @return
	 */
	public int trailingZeroes(int n) {
		if (n < 5) return 0;
        int result = (n = n / 5);
		return result + trailingZeroes(n);
    }
}
