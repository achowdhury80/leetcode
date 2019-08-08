package com.leet.algo;
import java.util.*;
public class Prob1023 {
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		char[] arr = pattern.toCharArray();
		for (String q : queries) {
			int i = 0;
			char[] arr1 = q.toCharArray();
			boolean flag = true;
			for (int j = 0; j < arr1.length; j++) {
				if (i < arr.length && arr[i] == arr1[j]) {
					i++;
				} else {
					if (!Character.isLowerCase(arr1[j])) {
						flag = false;
						break;
					}
				}
			}
			if (i < arr.length) flag = false;
			result.add(flag);
			
		}
		return result;
    }
	
	public static void main(String[] argw) {
		Prob1023 prob = new Prob1023();
		System.out.println(prob.camelMatch(new String[] {"FooBar"}, "FB"));
	}
}
