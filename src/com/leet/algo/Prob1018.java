package com.leet.algo;
import java.util.*;
public class Prob1018 {
	public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < A.length; i++) {
        	num = (num * 2 + A[i]) % 5;
        	result.add(num % 5 == 0);
        }
        return result;
    }
}
