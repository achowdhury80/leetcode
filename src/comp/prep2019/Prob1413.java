package comp.prep2019;

public class Prob1413 {
	public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : nums) {
        	sum += i;
        	min = Math.min(min, sum);
        }
        if (min < 1) {
        	return 1 - min;
        }
        return 1;
    }
}
