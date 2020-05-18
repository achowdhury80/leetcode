package comp.prep2019;
import java.util.*;
public class Prob1140 {
	public int stoneGameII(int[] piles) {
        Map<String, Integer> map = new HashMap<>();
        int[] sum = new int[piles.length + 1];
        for (int i = 0; i < piles.length; i++) {
        	sum[i + 1] = sum[i] + piles[i];
        }
        return helper(piles, 0, 1, map, sum);
    }
	
	private int helper(int[] piles, int start, int m, Map<String, Integer> map, int[] sum) {
		String key = start + "-" + m;
		if (map.containsKey(key)) return map.get(key);
		int max = 0;
		for (int i = start; i < start + 2 * m && i < piles.length; i++) {
			int nextM = Math.max(m, i - start + 1);
			int remaining = 0;
			if (i < piles.length - 1) {
				remaining = sum[piles.length] - sum[i + 1] - helper(piles, i + 1, nextM, map, sum);
			} 
			max = Math.max(max, sum[i + 1] - sum[start] + remaining);
		}
		map.put(key, max);
		return map.get(key);
	}
}
