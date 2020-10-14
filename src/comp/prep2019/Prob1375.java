package comp.prep2019;

public class Prob1375 {
	/**
	 * O(N)
	 * @param light
	 * @return
	 */
	public int numTimesAllBlue(int[] light) {
        int maxSoFar = 0, result = 0;;
        for (int i = 0; i < light.length; i++) {
        	maxSoFar = Math.max(maxSoFar, light[i]);
        	if (i + 1 == maxSoFar) result++;
        }
        return result;
    }
}
