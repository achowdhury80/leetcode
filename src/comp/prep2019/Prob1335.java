package comp.prep2019;
import java.util.*;
public class Prob1335 {
	public int minDifficulty(int[] jobDifficulty, int d) {
        return findMin(jobDifficulty, 0, d, new HashMap<>());
    }
	
	private int findMin(int[] jobDifficulty, int start, int d, 
			Map<String, Integer> cache) {
		String key = start + "," + d;
		if (cache.containsKey(key)) return cache.get(key);
		int n = jobDifficulty.length;
		if (d > n) return -1;
		if (d == 1) {
			int result = Integer.MIN_VALUE;
			for (int i = start; i < n; i++) {
				result = Math.max(result, jobDifficulty[i]);
			}
			cache.put(key, result);
			return result;
		}
		int max = Integer.MIN_VALUE;
		int result = Integer.MAX_VALUE;
		for (int i = start; i + d <= n; i++) {
			max = Math.max(max, jobDifficulty[i]);
			result = Math.min(result, max 
					+ findMin(jobDifficulty, i + 1, d - 1, cache));
		}
		cache.put(key, result);
		return result;
	}
	
	public static void main(String[] args) {
		Prob1335 prob = new Prob1335();
		System.out.println(prob.minDifficulty(new int[] {11,111,22,222,33,333,44,
				444}, 6));
	}
}
