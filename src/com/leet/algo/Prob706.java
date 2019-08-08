package com.leet.algo;

public class Prob706 {
	private int[] nums;
	public Prob706() {
		nums = new int[1000001];
		for (int i = 0; i < nums.length; i++) nums[i] = -1;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	nums[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return nums[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	nums[key] = -1;
    }
}
