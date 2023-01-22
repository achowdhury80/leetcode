package com.prep2020.hard;
import java.util.*;
public class Problem1095 {
	public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        Map<Integer, Integer> map = new HashMap<>();
        int[] peek = new int[] {0, n -1};
        int peekIndex = findPeekIndex(mountainArr, map, peek);
        if (find(peekIndex, mountainArr, map) == target) return peekIndex;
        int idx = -1;
        if ((idx = search(0, peekIndex - 1, mountainArr, target, true, map)) > -1) return idx;
        if ((idx = search(peekIndex + 1, n - 1, mountainArr, target, false, map)) > -1) return idx;
        return -1;
    }
	
	private int findPeekIndex(MountainArray mountainArr, Map<Integer, Integer> map, int[] peek) {
		if (peek[0] == peek[1]) return peek[0];
		if (peek[0] + 1 == peek[1]) {
			int left = find(peek[0], mountainArr, map);
	    	int right = find(peek[1], mountainArr, map);
	    	if (left > right) return peek[0];
	    	return peek[1];
		}
		int mid = peek[0] + (peek[1] - peek[0]) / 2;
    	int num1 = find(mid, mountainArr, map), num2 = find(mid + 1, mountainArr, map);
    	if (num1 < num2) return findPeekIndex(mountainArr, map, new int[] {mid + 1, peek[1]});
    	return findPeekIndex(mountainArr, map, new int[] {peek[0], mid});
	}
	
	private int search(int start, int end, MountainArray mountainArr, int target, boolean asc, Map<Integer, Integer> map) {
		if (end - start < 2) {
			int left = find(start, mountainArr, map);
			if (left == target) return start;
	    	int right = find(end, mountainArr, map);
	    	if (right == target) return end;
	    	return -1;
		}
		int mid = start + (end - start) / 2;
		int num = find(mid, mountainArr, map);
		if (num == target) return mid;
		if (num > target) {
			if (asc) return search(start, mid - 1, mountainArr, target, asc, map);
			else return search(mid + 1, end, mountainArr, target, asc, map);
		} else {
			if (asc) return search(mid + 1, end, mountainArr, target, asc, map);
			else return search(start, mid - 1, mountainArr, target, asc, map);
		}
	}
	
	private int find(int index, MountainArray mountainArr, Map<Integer, Integer> map) {
		if (!map.containsKey(index)) map.put(index, mountainArr.get(index));
		return map.get(index);
	}
	interface MountainArray {
		      public int get(int index);
		     public int length();
		 }
	
	
	public static void main(String[] args) {
		Problem1095 problem = new Problem1095();
		System.out.println(problem.findInMountainArray(0, new MountainArray() {
			int[] arr = new int[] {0,1,5,3,0};
			@Override
			public int length() {
				// TODO Auto-generated method stub
				return 5;
			}
			
			@Override
			public int get(int index) {
				// TODO Auto-generated method stub
				return arr[index];
			}
		}));
	}
}
