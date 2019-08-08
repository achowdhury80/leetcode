package com.leet.algo;
import java.util.*;
public class Prob989 {
	 public List<Integer> addToArrayForm(int[] A, int K) {
		 List<Integer> result = new ArrayList<>();
		 int carry = 0;
		 for (int i = A.length - 1; i > -1 || K > 0; i--) {
			 int sum = (i > - 1 ? A[i] : 0) + (K % 10) + carry;
			 result.add(0, sum % 10);
			 carry = sum / 10;
			 K /= 10;
		 }
		 if (carry > 0) result.add(0, carry);
		 return result;
	 }
}
