package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2080 {
	private Map<Integer, List<Integer>> map;
	public Problem2080(int[] arr) {
        map = new HashMap<>();
        for (int i  = 0; i < arr.length; i++) {
        	List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
        	list.add(i);
        	map.put(arr[i], list);
        }
    }
    
    public int query(int left, int right, int value) {
    	if (!map.containsKey(value)) return 0;
    	List<Integer> list = map.get(value);
    	int leftIdx = Collections.binarySearch(list, left), rightIdx = Collections.binarySearch(list, right);
    	if (leftIdx < 0) leftIdx = -(leftIdx + 1);
    	if (leftIdx == list.size()) return 0;
    	if (rightIdx < 0) rightIdx = -(rightIdx + 1) - 1;
    	return rightIdx - leftIdx + 1;
    }
    
    public static void main(String[] args) {
    	Problem2080 problem = new Problem2080(new int[] {12,33,4,56,22,2,34,33,22,12,34,56});
    	System.out.println(problem.query(1, 2, 4));
    }
}
