package comp.prep2019;
import java.util.*;
public class Prob1420 {
	private int MOD = (int) (1e9 + 7);
	public int numOfArrays(int n, int m, int k) {
        return helper(n, m, k, new HashMap<>());
    }
	
	public int helper(int n, int m, int k, Map<String, Integer> cache) {
        if(n < 1 || n < k || k == 0 || k > m) return 0;
        String key = n + "#" + m + "#" + k;
        if (cache.containsKey(key)) return cache.get(key);
        long result = 0;
        for (int i = k - 1; i <= m; i++) {
        	for (int j = 0; j < n; j++) {
        		int left = j == 0 ? 1 : numOfArrays(j - 1, i - 1, k - 1);
        		if (left != 0) {
        			long right = (long)Math.pow(i, (n - j - 1)) % MOD;
        			result = (result + (left * right) % MOD) % MOD;
        		}
        	}
        }
        cache.put(key, (int)(result % MOD));
        return cache.get(key);
    }
	
	public static void main(String[] args) {
		Prob1420 prob = new Prob1420();
		System.out.println(prob.numOfArrays(2, 3, 1));
		System.out.println(prob.numOfArrays(50, 100, 25));
	}
}
