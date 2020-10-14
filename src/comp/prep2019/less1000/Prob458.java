package comp.prep2019.less1000;

public class Prob458 {
	/**
	 * inspired from https://leetcode.com/problems/poor-pigs/solution/
	 * @param buckets
	 * @param minutesToDie
	 * @param minutesToTest
	 * @return
	 */
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int states = minutesToTest / minutesToDie + 1;
		return (int)Math.ceil(Math.log(buckets) / Math.log(states));
    }
}
 	