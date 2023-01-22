package com.prep2020.easy;
import java.util.*;
public class Problem1656 {
	private String[] arr;
	private int cur = 0;
	public Problem1656(int n) {
        arr = new String[n];
    }
    
    public List<String> insert(int id, String value) {
        arr[id - 1] = value;
        List<String> result = new ArrayList<>();
        if (cur == id - 1) {
        	while(cur < arr.length && arr[cur] != null) result.add(arr[cur++]);
        } 
        return result; 
    }
}
