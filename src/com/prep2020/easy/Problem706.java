package com.prep2020.easy;

public class Problem706 {
	private int[] arr;
	/** Initialize your data structure here. */
    public Problem706() {
        arr = new int[1000001];
        for (int i = 0; i < arr.length; i++) arr[i] = -1;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return arr[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = -1;
    }
}
