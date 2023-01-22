package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2195 {
	public long minimalKSum(int[] nums, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : nums) treeSet.add(i);
        int last = 0;
        long sum = 0, count = 0;
        for (int i : treeSet) {
        	if (i > last + 1) {
        		int gap = i - last - 1;
        		long elementsToBeRetrieved = Math.min(gap, k - count);
        		sum += (elementsToBeRetrieved * (2 * (last + 1l) + (elementsToBeRetrieved - 1))) / 2;
        		count += elementsToBeRetrieved;
        		if (count == k) break;
        	}
        	last = i;
        }
        if (count < k) {
        	long elementsToBeRetrieved = k - count;
    		sum += (elementsToBeRetrieved * (2 * (last + 1l) + (elementsToBeRetrieved - 1))) / 2;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		Problem2195 problem = new Problem2195();
		System.out.println(problem.minimalKSum(new int[] {1, 4, 25, 10, 25}, 2));
		System.out.println(problem.minimalKSum(new int[] {5, 6}, 6));
	}
}
