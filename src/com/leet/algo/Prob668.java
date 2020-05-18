package com.leet.algo;
import java.util.*;
/**
 * Created by ayanc on 1/25/18.
 */
public class Prob668 {
	/**
	 had TLE
  public int findKthNumber(int m, int n, int k) {
    Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
    for (int i = 1; i <= m; i++) {
    	for (int j = 1; j <= n; j++) {
    		int mul = i * j;
    		if (q.size() < k) q.offer(mul);
    		else if(q.peek() > mul) {
    			q.poll();
    			q.offer(mul);
    		}
    	}
    }
    return q.peek();
  }
  */
	
	public int findKthNumber(int m, int n, int k) {
		int low = 1, high = m * n + 1;
		while(low < high) {
			int mid = low + (high - low) / 2;
			int c = count(mid, m, n);
			if (c >= k) high = mid;
			else low = mid + 1;
		}
		return high;
	}
	
	/**
	 * returns number of elements <= val
	 * @param val
	 * @param m
	 * @param n
	 * @return
	 */
	private int count(int val, int m, int n) {
		int count = 0;
		for (int i = 1; i <= m; i++) {
			int temp = Math.min(val / i, n); // number of elements <= val for i
			count += temp;
		}
		return count;
	}
  
  public static void main(String[] args) {
	  Prob668 prob = new Prob668();
	  System.out.println(prob.findKthNumber(3, 3, 5));
	  System.out.println(prob.findKthNumber(2, 3, 6));
  }
}
