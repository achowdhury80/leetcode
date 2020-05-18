package comp.prep2019;
import java.util.*;
public class Prob1416 {
	public int numberOfArrays(String s, int k) {
		int mod = (int)(1e9 + 7);
        return helper(s, k, 0, new HashMap<>(), mod);
    }
	
	private int helper(String s, int k, int start, Map<Integer, Integer> cache, int mod) {
		if (cache.containsKey(start)) return cache.get(start);
		if (s.charAt(start) == '0') {
			cache.put(start, 0);
			return 0;
		}
		long result = 0;
		for (int i = start; i < s.length(); i++) {
			long left = Long.parseLong(s.substring(start, i + 1));
			if (left > k) break;
			if (i == s.length() - 1) {
				result = (result + 1) % mod;
			} else {
				int rightComibinations = helper(s, k, i + 1, cache, mod);
				result = (result + rightComibinations) % mod;
			}
			
		}
		cache.put(start, (int)result);
		return cache.get(start);
	}
	
	public static void main(String[] args) {
		Prob1416 prob = new Prob1416();
		System.out.println(prob.numberOfArrays("1317", 2000));
	}
}
