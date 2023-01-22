package com.prep2020.easy;
import java.util.*;
public class Problem1346 {
	/**
	 * O(N) time and Space
	 * @param arr
	 * @return
	 */
	public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
        	if ((num % 2 == 0 && set.contains(num / 2)) || set.contains(2 * num)) return true;
        	set.add(num);
        }
        return false;
    }
}
