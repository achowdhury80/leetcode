package comp.prep2019.less1000;
import java.util.*;

public class Prob903 {
	public int numPermsDISequence(String S) {
        return (int)permutation(0, S.length() - 1, S, (long)(1e9 + 7), 
        		new HashMap<>(), new HashMap<>());
    }
	
	private long permutation(int i, int j, String s, long mod, 
			Map<Integer, Long> cache, Map<Integer, Long> factCache) {
		if (i >= j) return 1;
		int key = (i << 8) | j;
		if (cache.containsKey(key)) return cache.get(key);
		long result = 0;
		int n = j - i + 2;
		if (s.charAt(i) == 'I') result = (result 
				+ permutation(i + 1, j, s, mod, cache, factCache)) % mod;  
		if (s.charAt(j) == 'D') result = (result 
				+ permutation(i, j - 1, s, mod, cache, factCache)) % mod; 
		for (int k = i + 1; k < j + 1; k++) {
			if (s.charAt(k - 1) == 'D' && s.charAt(k) == 'I') {
				result = (result + ((binom(n - 1, k - i, mod, factCache) 
						* permutation(i, k - 2, s, mod, cache, factCache)) % mod
						* permutation(k + 1, j, s, mod, cache, factCache)) % mod) 
						% mod;
			}
		}
		cache.put(key, result);
		return result;
	}
	
	 private long binom(int i, int j, long mod, Map<Integer, Long> factCache) {
		// TODO Auto-generated method stub
		return (fact(i, mod, factCache) * mod / ((fact(j, mod, factCache) 
				* fact(i - j, mod, factCache)) % mod)) % mod;
	 }
	 
	 private long fact(int i, long mod, Map<Integer, Long> factCache) {
		 if (i < 2) return 1;
		 if (factCache.containsKey(i)) return factCache.get(i);
		 factCache.put(i,  (i * fact(i - 1, mod, factCache)) % mod);
		 return factCache.get(i);
	 }
}
