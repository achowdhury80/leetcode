package com.prep2020.hard;
import java.util.*;
public class Problem936 {
	public int[] movesToStamp(String stamp, String target) {
        List<Integer> list = new ArrayList<>();
        int idx = -1;
        if ((idx = target.indexOf(stamp)) < 0) return new int[0];
        list.add(idx);
        char[] arr = target.toCharArray();
        makeDontCare(arr, idx, idx + stamp.length() -1);
        int replacedCount = stamp.length();
        while(replacedCount < target.length() && (idx = findNextIndex(arr, stamp)) > -1) {
        	list.add(0, idx);
        	replacedCount += makeDontCare(arr, idx, idx + stamp.length() -1);
        }
        if(replacedCount < target.length()) return new int[0];
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

	private int findNextIndex(char[] arr, String stamp) {
		int n = stamp.length();
		for (int i = 0; i + n - 1 < arr.length; i++) {
			if (match(arr, i, stamp)) return i;
		}
		return -1;
	}

	private boolean match(char[] arr, int i, String stamp) {
		boolean matched = false;
		for (int k = 0; k < stamp.length(); k++) {
			if (arr[i + k] == '?') continue;
			if (arr[i + k] != stamp.charAt(k)) return false;
			matched = true;
		}
		return matched;
	}

	private int makeDontCare(char[] arr, int i, int j) {
		int result = 0;
		for(int k = i; k <= j; k++) {
			if (arr[k] != '?') {
				result++;
				arr[k] = '?';
			}
		}
		return result;
	}
}
