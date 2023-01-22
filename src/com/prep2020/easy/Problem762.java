package com.prep2020.easy;
import java.util.*;
public class Problem762 {
	/**
	 * O(R - L)
	 * @param L
	 * @param R
	 * @return
	 */
	public int countPrimeSetBits(int L, int R) {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        set.add(23);
        set.add(29);
        set.add(31);
        int result = 0;
        for (int i = L; i <= R; i++) {
        	if (set.contains(Integer.bitCount(i))) result++;
        }
        return result;
        
    }
}
