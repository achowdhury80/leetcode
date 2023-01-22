package com.prep2020.medium;
import java.util.*;
public class Problem519 {
	private Set<Integer> set;
	private int n_rows, n_cols;
	private Random random;
	public Problem519(int n_rows, int n_cols) {
		this.n_rows = n_rows;
		this.n_cols = n_cols;
		this.random = new Random();
		this.set = new HashSet<>();
    }
    
    public int[] flip() {
    	int size = n_rows * n_cols;
    	int next;
    	while(set.contains(next = random.nextInt(size)));
    	set.add(next);
        return new int[] {next / n_cols, next % n_cols};
    }
    
    public void reset() {
    	set.clear();
    }
}
