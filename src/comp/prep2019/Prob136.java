package comp.prep2019;

public class Prob136 {
	public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) result ^= i;
        return result;
    }
}
