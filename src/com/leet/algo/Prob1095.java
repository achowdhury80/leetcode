package com.leet.algo;
import java.util.*;
public class Prob1095 {
	public int findInMountainArray(int target, MountainArray mountainArr) {
        int result = -1;
        int n = mountainArr.length();
        Map<Integer, Integer> map = new HashMap<>();
        int peakIndex = findPeakIndex(0, n, map, mountainArr);
        if (target == get(peakIndex, map, mountainArr)) return peakIndex;
        if ((result = search(target, 0, peakIndex - 1, map, mountainArr, (x, y) -> x - y)) > - 1) return result;
        return search(target, peakIndex + 1, n - 1, map, mountainArr, (x, y) -> y - x);
    }
	
	private int search(int target, int start, int end,  Map<Integer, Integer> map, MountainArray mountainArr, Comparator<Integer> comparator) {
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int cmp = comparator.compare(get(mid, map, mountainArr), target);
			if (cmp == 0) return mid;
			if (cmp < 0) start = mid + 1;
			else end = mid - 1;
		}
		return result;
	}
	
	private int findPeakIndex(int start, int end, Map<Integer, Integer> map, MountainArray mountainArr) {
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (get(mid, map, mountainArr) > get(mid - 1, map, mountainArr)) start = mid;
			else end = mid;
		}
		return start;
	}
	
	private int get(int index, Map<Integer, Integer> map, MountainArray mountainArr) {
		if (!map.containsKey(index)) map.put(index, mountainArr.get(index));
			return map.get(index);
	}
	
	static class MountainArray {
		int[] arr = new int[] {1,5, 2};
		int get(int k) {
			return arr[k];
		}
		int length() {
			return arr.length;
		}
	}
	
	
	public static void main(String[] args) {
		Prob1095 prob = new Prob1095();
		System.out.println(prob.findInMountainArray(1, new MountainArray()));
	}
}
