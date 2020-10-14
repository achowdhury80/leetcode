package comp.prep2019.less2000;

import java.util.HashSet;
import java.util.Set;

public class Prob1044 {
	public String longestDupSubstring(String S) {
		int n = S.length();
		// convert string to array of integers
	    // to implement constant time slice
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) nums[i] = S.charAt(i) - 'a';
		// base value for the rolling hash function
	    int a = 26;
	    // modulus value for the rolling hash function to avoid overflow
	    long modulus = (long)Math.pow(2, 32);
	    //binary search, L = repeating string length
	    int left = 1, right = n - 1;
	    while(left <= right) {
	    	int mid = left + (right - left) / 2;
	    	if (search(mid, a, modulus, nums) != -1) left = mid + 1;
	    	else right = mid - 1;
	    }
	    if (left < 2) return "";
	    int start = search(left - 1, a, modulus, nums);
	    return S.substring(start, start + left - 1);
    }

	/*
	  Rabin-Karp with polynomial rolling hash.
	      Search a substring of given length
	      that occurs at least 2 times.
	      Return start position if the substring exits and -1 otherwise.
	      */
	private int search(int L, int a, long modulus, int[] nums) {
		// compute the hash of string S[:L]
		long h = 0;
		for (int i = 0; i < L; i++) {
			h = (h * a + nums[i]) % modulus;
		}
		// already seen hashes of strings of length L
	    Set<Long> seen = new HashSet<>();
	    seen.add(h);
	    
	    // const value to be used often : a**L % modulus
	    long aL = 1;
	    for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;
	    
	    for(int start = 1; start < nums.length - L + 1; ++start) {
	    	// compute rolling hash in O(1) time
	    	h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
	    	h = (h + nums[start + L - 1]) % modulus;
	    	if (seen.contains(h)) return start;
	    	seen.add(h);
	    }
	    return -1;
	}
}
