package com.leet.algo;
import java.util.*;
public class Prob1099 {
	public int twoSumLessThanK(int[] A, int K) {
        if (A.length < 2) return -1;
        TreeSet<Integer> set = new TreeSet<>();
        int result = -1;
        for (int a : A) {
        	int b = K - a - 1;
        	Integer c;
        	if ((c = set.floor(b)) != null) {
        		result = Math.max(result, a + c);
        	}
        	set.add(a);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1099 prob = new Prob1099();
		System.out.println(prob.twoSumLessThanK(new int[] {34,23,1,24,75,33,54,8}, 60));
	}
}
