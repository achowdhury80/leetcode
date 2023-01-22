package com.prep2020.medium;
import java.util.*;
public class Problem1981 {
	public int minimizeTheDifference(int[][] mat, int target) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < mat.length; i++) {
        	boolean[] used = new boolean[71];
        	List<Integer> temp = new ArrayList<>();
        	for (int j : mat[i]) {
        		if (used[j]) continue;
        		used[j] = true;
        		for (int k : list) {
        			int val = j + k;
        			if (val > target && !temp.isEmpty() && temp.get(temp.size() - 1) > target) {
        				if(val >= temp.get(temp.size() - 1)) continue;
        				else temp.remove(temp.size() - 1);
        			}
        			int pos = Collections.binarySearch(temp, val);
        			if (pos > -1) continue;
        			pos = -(pos + 1);
        			temp.add(pos, val);
        		}
        	}
        	list = temp;
        }
        
        int index = Collections.binarySearch(list, target);
        if (index >= 0) return 0;
        index = - (index + 1);
        if (index == 0) return list.get(0) - target;
        else if (index == list.size()) return target - list.get(list.size() - 1);
        return Math.min(list.get(index) - target, target - list.get(index - 1));
    }
	
	public static void main(String[] args) {
		Problem1981 problem = new Problem1981();
		System.out.println(problem.minimizeTheDifference(new int[][] {{1, 2, 3}, {4, 5, 6}, {7,8,9}}, 13));
	}
}
