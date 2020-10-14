package comp.prep2019.less1000;

public class Prob453 {
	/**
	 * O(N)
	 * k * (n - 1) + s = (min + k) n
	 * k is the number move
	 * @param nums
	 * @return
	 */
	public int minMoves(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i : nums) {
        	sum += i;
        	min = Math.min(min, i);
        }
        return sum - nums.length * min;
    }
}
