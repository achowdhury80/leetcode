package com.prep2020.easy;
import java.util.*;
public class Problem170 {
	private List<Integer> list;
	/** Initialize your data structure here. */
    public Problem170() {
        list = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int idx = Collections.binarySearch(list, number);
        if (idx < 0) idx = -(idx + 1);
        list.add(idx, number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
        	long sum = 0l + list.get(i) + list.get(j);
        	if (sum == value) return true;
        	if (sum > value) j--;
        	else i++;
        }
        return false;
    }
}
