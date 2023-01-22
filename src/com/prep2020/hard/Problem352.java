package com.prep2020.hard;
import java.util.*;
public class Problem352 {
	private List<int[]> list;
	public Problem352() {
        list = new ArrayList<>();
    }
    
    public void addNum(int val) {
        if (list.isEmpty()) {
        	list.add(new int[] {val, val});
        	return;
        }
        int low = 0, high = list.size() - 1;
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	int[] intv = list.get(mid);
        	if (intv[0] <= val && intv[1] >= val) return;
        	if (val < intv[0]) high = mid - 1;
        	else low = mid + 1;
        }
        int[] intv = list.get(low);
    	if (intv[0] <= val && intv[1] >= val) return;
    	int start = low;
    	if (val < intv[0]) {
    		list.add(low, new int[] {val, val});
    		if (low != 0 && list.get(low - 1)[1] == val -1) {
    			list.get(low - 1)[1] = val;;
    			list.remove(low);
    			start = low - 1;
    		} else start = low;
    	} else {
    		list.add(low + 1, new int[] {val, val});
    		if (low > -1 && list.get(low)[1] == val -1) {
    			list.get(low)[1] = val;
    			list.remove(low + 1);
    			start = low;
    		}
    		else start = low + 1;
    	}
        while (start < list.size() - 1 && list.get(start)[1] == list.get(start + 1)[0] - 1) {
        	list.get(start)[1] = list.get(start + 1)[1];
        	list.remove(start + 1);
        }
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
