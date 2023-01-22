package com.prep2020.easy;
import java.util.*;
public class Problem1018 {
	public List<Boolean> prefixesDivBy5(int[] A) {
		List<Boolean> result = new ArrayList<>();
		int cur = 0;
		for (int i = 0; i < A.length; i++) {
			cur = (cur << 1) % 5 + A[i];
			if (cur % 5 == 0) result.add(true);
			else result.add(false);
		}
		return result;
    }
}
