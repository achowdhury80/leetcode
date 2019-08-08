package com.leet.algo;
import java.util.*;
public class Prob904 {
	public int totalFruit(int[] tree) {
        int result = 1;
        int start = 0;
        Set<Integer> set = new HashSet<>();
        set.add(tree[start]);
        int lastChangeIndex = start;
        for (int i = 1; i < tree.length; i++) {
        	if (tree[i] != tree[i - 1]) {
        		if (!set.contains(tree[i])) {
        			if (set.size() < 2) {
        				set.add(tree[i]);
        				result = Math.max(result, i - start + 1);
        			}
        			else {
        				
        				set.remove(tree[start]);
        				start = lastChangeIndex;
        				result = Math.max(result, i - start + 1);
        				set.add(tree[i]);
        			}
        			lastChangeIndex = i;
        		} else {
        			result = Math.max(result, i - start + 1);
        		}
        	} 
        	else result = Math.max(result, i - start + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob904 prob = new Prob904();
		//System.out.println(prob.totalFruit(new int[] {1, 2, 1}));
		System.out.println(prob.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
	}
}
