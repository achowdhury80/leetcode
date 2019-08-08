package com.leet.algo;
import java.util.*;
public class Prob933 {
	private List<Integer> list;
	private int size;
	public Prob933() {
        list = new ArrayList<>();
        size = 0;
    }
    
    public int ping(int t) {
        list.add(t);
        size++;
        while(list.get(0) < t - 3000) {
        	list.remove(0);
        	size--;
        }
        return size;
    }
}
