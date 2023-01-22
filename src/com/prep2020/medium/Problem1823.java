package com.prep2020.medium;
import java.util.*;
public class Problem1823 {
	/**
	 * O(N)
	 * @param n
	 * @param k
	 * @return
	 */
	public int findTheWinner(int n, int k) {
		if ( k == 1) return n;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int cur = 0;
        while(list.size() > 1) {
        	int kAdjusted = (k - 1) % list.size();
        	int removeIndex = (cur + kAdjusted) % list.size();
        	list.remove(removeIndex);
        	if (removeIndex == list.size()) cur = 0;
        	else cur = removeIndex;
        }
        return list.get(0);
    }
	
	public static void main(String[] args) {
		Problem1823 problem = new Problem1823();
		System.out.println(problem.findTheWinner(5, 2));
	}
}
