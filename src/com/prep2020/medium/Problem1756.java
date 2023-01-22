package com.prep2020.medium;
import java.util.*;
public class Problem1756 {
	private List<Integer> list;
	public Problem1756(int n) {
		list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
    }
    
    public int fetch(int k) {
        int result = -1;
        list.add((result = list.remove(k - 1)));
        return result;
    }
}
