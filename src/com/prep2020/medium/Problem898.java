package com.prep2020.medium;
import java.util.*;
public class Problem898 {
	public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>(), temp = new HashSet<>();
        for (int i : arr) {
        	Set<Integer> temp2 = new HashSet<>();
        	for (int a : temp) temp2.add(i | a);
        	temp2.add(i);
        	set.addAll(temp2);
        	temp = temp2;
        }
        return set.size();
    }
}
