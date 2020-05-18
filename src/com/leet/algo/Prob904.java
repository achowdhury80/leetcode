package com.leet.algo;
import java.util.*;
public class Prob904 {
	public int totalFruit(int[] tree) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int types = 0;
        int j = 0;
        for (int i = 0; i < tree.length; i++) {
        	if (!map.containsKey(tree[i])) {
        		types++;
        	}
        	map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
        	while(types > 2) {
        		map.put(tree[j], map.get(tree[j]) - 1);
        		if (map.get(tree[j]) == 0) {
        			types--;
        			map.remove(tree[j]);
        		}
        		j++;
        	}
        	result = Math.max(result, i - j + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob904 prob = new Prob904();
		//System.out.println(prob.totalFruit(new int[] {1, 2, 1}));
		System.out.println(prob.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
	}
}
