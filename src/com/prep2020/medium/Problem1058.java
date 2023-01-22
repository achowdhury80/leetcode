package com.prep2020.medium;
import java.util.*;
public class Problem1058 {
	public String minimizeError(String[] prices, int target) {
        List<Double> list = new ArrayList<>();
        for (String p : prices) {
        	double d = Double.parseDouble(p);
        	int a = (int) d;
        	target -= a;
        	d -= a;
        	if (d == 0) continue;
        	int idx = Collections.binarySearch(list, d);
        	if (idx < 0) idx = -(idx + 1);
        	list.add(idx, d);
        }
        int n = list.size();
        if (target < 0 || target > n) return "-1";
        int floor = n - target;
        double result = 0;
        for (int i = 0; i < n; i++) {
        	if (i < floor) result += list.get(i);
        	else result += 1 - list.get(i);
        }
        return String.format("%.3f", result);
    }
}
