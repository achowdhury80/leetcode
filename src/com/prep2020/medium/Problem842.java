package com.prep2020.medium;
import java.util.*;
public class Problem842 {
	public List<Integer> splitIntoFibonacci(String num) {
		int n = num.length();
        for (int i = 0; i < n / 2; i++) {
        	if (i > 0 && num.charAt(0) == '0') break;
        	long first = Long.parseLong(num.substring(0, i + 1));
        	if (first > Integer.MAX_VALUE) break;
        	for (int j = i + 1; j < (2 * n) / 3; j++) {
        		if (j > i + 1 && num.charAt(i + 1) == '0') break;
        		long second = Long.parseLong(num.substring(i + 1, j + 1));
            	if (second > Integer.MAX_VALUE) break;
        		List<Integer> list = findSequence(num.substring(j + 1), (int)first, (int)second);
        		if (list == null) continue;
        		list.add(0, (int)second);
        		list.add(0, (int)first);
        		if (list.size() > 2) return list;
        	}
        }
        return new ArrayList<>();
    }

	private List<Integer> findSequence(String num, int first, int second) {
		if ("".equals(num)) return new ArrayList<>();
		if (0l + first + second > Integer.MAX_VALUE) return null;
		int third = first + second;
		List<Integer> result = new ArrayList<>();
		if (!num.startsWith("" + third)) return null;
		result.add(third);
		List<Integer> list = findSequence(num.substring(("" + third).length()), second, third);
		if (list == null) return null;
		result.addAll(list);
		return result;
	}
	
	public static void main(String[] args) {
		Problem842 problem = new Problem842();
		System.out.println(problem.splitIntoFibonacci("1101111"));
	}
}
