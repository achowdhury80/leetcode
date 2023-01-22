package com.prep2020.medium;
import java.util.*;
public class Problem967 {
	public int[] numsSameConsecDiff(int n, int k) {
		List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) list.add(i);
        for (int i = 1; i < n; i++) {
        	List<Integer> temp = new ArrayList<>();
        	for (int j : list) {
        		int last = j % 10;
        		if (last + k < 10) temp.add(j * 10 + last + k);
        		if (k > 0 && last - k > -1) temp.add(j * 10 + last - k);
        	}
        	list = temp;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
	
	public static void main(String[] args) {
		Problem967 problem = new Problem967();
		System.out.println(problem.numsSameConsecDiff(3, 7));
	}
}
