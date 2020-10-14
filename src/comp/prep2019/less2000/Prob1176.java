package comp.prep2019.less2000;

public class Prob1176 {
	/**
	 * O(N) time
	 * @param calories
	 * @param k
	 * @param lower
	 * @param upper
	 * @return
	 */
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) sum += calories[i];
        if (sum < lower) result--;
        else if (sum > upper) result++;
        for (int i = k; i < calories.length; i++) {
        	sum += calories[i] - calories[i - k];
        	if (sum < lower) result--;
            else if (sum > upper) result++;
        }
        return result;
    }
}
