package com.leet.algo;
import java.util.*;
public class Prob1012 {
	/**
	 * https://leetcode.com/problems/numbers-with-repeated-digits/discuss/256725/JavaPython-Count-the-Number-Without-Repeated-Digit
	 * @param N
	 * @return
	 */
	public int numDupDigitsAtMostN(int N) {
        int x = N + 1;
        List<Integer> list = new ArrayList<>();
        while(x > 0) {
        	list.add(0, x % 10);
        	x /= 10;
        }
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
        	result += 9 * perm(9, i - 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
        	for (int j = i > 0 ? 0 : 1; j < list.get(i) ; j++) {
        		if (!seen.contains(j)) {
        			result += perm(9 - i, list.size() - i - 1);
        		}
        	}
        	if (seen.contains(list.get(i))) break;
        	seen.add(list.get(i));
        }
        return N - result;
    }
	
	private int perm(int digits, int places) {
		return places == 0 ? 1 : digits * perm(digits - 1, places - 1);
	}
}
