package com.leet.algo;
import java.util.*;
public class Prob898 {
	public int subarrayBitwiseORs(int[] A) {
        Set<Integer> result = new HashSet<>(), cur = new HashSet<>();
        for (int i : A) {
        	Set<Integer> cur2 = new HashSet<>();
        	cur2.add(i);
        	for (int j : cur) cur2.add(i | j);
        	result.addAll(cur = cur2);
        }
        return result.size();
    }
}
