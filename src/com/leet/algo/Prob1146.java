package com.leet.algo;
import java.util.*;
public class Prob1146 {
	private Map<Integer, Integer> ops;
	private Map<Integer, Map<Integer, Integer>> snaps;
	private int lastSnap = -1;
	public Prob1146(int length) {
        ops = new HashMap<>();
        snaps = new HashMap<>();
    }
    
    public void set(int index, int val) {
        ops.put(index, val);
    }
    
    public int snap() {
        ++lastSnap;
        snaps.put(lastSnap, ops);
        ops = new HashMap<>(ops);
        return lastSnap;
    }
    
    public int get(int index, int snap_id) {
        if (snaps.get(snap_id).containsKey(index)) return snaps.get(snap_id).get(index);
        return 0;
    }
    
    public static void main(String[] args) {
    	Prob1146 prob = new Prob1146(1);
    	prob.set(0, 15);
    	System.out.println(prob.snap());
    	System.out.println(prob.snap());
    	System.out.println(prob.snap());
    	System.out.println(prob.get(0, 2));
    	System.out.println(prob.snap());
    	System.out.println(prob.snap());
    	System.out.println(prob.get(0, 2));
    }
}
