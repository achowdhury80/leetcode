package comp.prep2019.less1000;
import java.util.*;
public class Prob552 {
	public int checkRecord(int n) {
        if (n < 1) return 0;
        return (int) helper(n, false, 0, new HashMap<>(), (long)(1e9 + 7));
    }
	
	private long helper(int n, boolean aUsed, int lastTwo, Map<Integer, Long> cache, 
			long mod) {
		if (n == 0) return 1;
		int key = generateKey(aUsed, lastTwo, n);
		if (cache.containsKey(key)) return cache.get(key);
		long result = helper(n - 1, aUsed, 0, cache, mod);
		if (!aUsed) result = (result + helper(n - 1, true, 0, cache, mod)) % mod;
		if (lastTwo != 3) {
			result = (result + helper(n - 1, aUsed, lastTwo % 2 == 1 ? 3 : 1, 
					cache, mod)) % mod;
		}
		
		cache.put(key, result);
		return result;
	}

	private int generateKey(boolean aUsed, int lastTwo, int n) {
		int result = 0;
		if (aUsed) result |= (1 << 19);
		result |= (lastTwo << 17);
		result |= n;
		return result;
	}
}
