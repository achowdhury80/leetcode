package com.leet.algo;

public class Prob705 {
	private boolean[] nums;
	public Prob705() {
		nums = new boolean[1000001];
    }
    
    public void add(int key) {
        nums[key] = true;
    }
    
    public void remove(int key) {
    	nums[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return nums[key];
    }
}
