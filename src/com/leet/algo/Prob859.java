package com.leet.algo;
import java.util.*;
public class Prob859 {
	public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2) return false;
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        List<Integer> diffs = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arrA.length; i++) {
        	if (arrA[i] != arrB[i]) diffs.add(i);
        	set.add(arrA[i]);
        }
        if (diffs.size() == 2) {
        	return arrA[diffs.get(0)] == arrB[diffs.get(1)] && arrA[diffs.get(1)] == arrB[diffs.get(0)];
        } else if (diffs.size() == 0) {
        	return set.size() < arrA.length;
        }
        return false;
    }
}
