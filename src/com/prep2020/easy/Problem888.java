package com.prep2020.easy;
import java.util.*;
public class Problem888 {
	public int[] fairCandySwap(int[] A, int[] B) {
        int diff = 0;
        for (int a : A) diff += a;
        Set<Integer> set = new HashSet<>();
        for (int b : B) {
        	diff -= b;
        	set.add(b);
        }
        int exchange = diff / 2;
        for (int a : A) {
        	if (set.contains(a - exchange)) return new int[] {a, a - exchange};
        }
        return null;
    }
}
