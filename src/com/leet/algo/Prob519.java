package com.leet.algo;
import java.util.*;
public class Prob519 {
	private Random random;
	private Set<Integer> set;
	private int rows;
	private int cols;
	private int size;
	public Prob519(int n_rows, int n_cols) {
        set = new HashSet<>();
        this.rows = n_rows;
        this.cols = n_cols;
        size = rows * cols;
        random = new Random();
    }
    
    public int[] flip() {
    	int num = random.nextInt(size);
        while(set.contains(num)) num = random.nextInt(size);
        set.add(num);
        return new int[] {num / cols, num % cols}; 
    }
    
    public void reset() {
    	set.clear();
    }
    
    public static void main(String[] args) {
    	Prob519 prob = new Prob519(2, 2);
    	int[] arr;
    	System.out.println((arr = prob.flip())[0] + ", " + arr[1]);
    	System.out.println((arr = prob.flip())[0] + ", " + arr[1]);
    	System.out.println((arr = prob.flip())[0] + ", " + arr[1]);
    }
}
