package com.prep2020.hard;
import java.util.*;
public class Problem1585 {
	/**
	 * The best way to solve this is to swap two numbers, which will help us to maintain the order.
A number can be moved to its left till it finds a smaller number, example, for case of 12543, 3 can only come till index 2
If we will go greedily and check if ith index of t is possible or not, then if we will reach the end, then we will return true.
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isTransformable(String s, String t) {
        int n = s.length();
        List<Integer>[] pos = new List[10];
        for (int i = 0; i < 10; i++) pos[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	int idx = s.charAt(i) - '0';
        	pos[idx].add(i);
        }
        for (int i = 0; i < n; i++) {
        	int tIdx = t.charAt(i) - '0';
        	if (pos[tIdx].isEmpty()) return false;
        	for (int j = 0; j < tIdx; j++) {
        		if (!pos[j].isEmpty() && pos[j].get(0) < pos[tIdx].get(0)) {
        			return false;
        		}
        	}
        	pos[tIdx].remove(0);
        }
        return true;
    }
	
	public static void main(String[] args) {
		Problem1585 problem = new Problem1585();
		//System.out.println(problem.isTransformable("34521", "23415"));
		System.out.println(problem.isTransformable("84532", "34852"));
	}
}
