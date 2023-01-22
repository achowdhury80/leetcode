package com.prep2020.easy;
import java.util.*;
public class Problem989 {
	public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int i = A.length - 1;
        int carry = 0;
        while(i > -1 || K > 0 || carry > 0) {
        	int sum = (i > -1 ? A[i] : 0) + (K % 10) + carry;
        	i--;
        	K /= 10;
        	result.add(0, sum % 10);
        	carry = sum / 10;
        }
        return result;
    }
}
