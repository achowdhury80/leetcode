package comp.prep2019.less1000;

public class Prob461 {
	/**
	 * O(1) time and space
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
