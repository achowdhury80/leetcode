package com.prep2020.medium;
import java.util.*;
public class Problem1352 {
	private List<Integer> list;
	public Problem1352() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {
        	list.clear();
        } else {
        	if (list.isEmpty()) list.add(num);
        	else list.add(list.get(list.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        if (k > list.size()) return 0;
        if (k == list.size()) return list.get(list.size() - 1);
        return list.get(list.size() - 1) / list.get(list.size() - 1 - k);
    }
}
