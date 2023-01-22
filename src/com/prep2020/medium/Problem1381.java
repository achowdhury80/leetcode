package com.prep2020.medium;
import java.util.*;
public class Problem1381 {
	private int n;
	private List<Integer> list;
	public Problem1381(int maxSize) {
		this.n = maxSize;
        list = new ArrayList<>();
    }
    
    public void push(int x) {
        if (list.size() == n) return;
        list.add(x);
    }
    
    public int pop() {
        if (list.isEmpty()) return -1;
        return list.remove(list.size() - 1);
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(list.size(), k); i++) list.set(i, list.get(i) + val);
    }
}
