package comp.prep2019.less1000;

public class Prob441 {
	/**
	 * O(1) time and space
	 * @param n
	 * @return
	 */
	public int arrangeCoins(int n) {
		return (int)((Math.sqrt(8 * (n + 0l) + 1) - 1) / 2);
    }
}
