package com.prep2020.easy;
import java.util.*;
public class Problem2094 {
	public int[] findEvenNumbers(int[] digits) {
        int[] arr = new int[10];
        for (int i : digits) arr[i]++;
        List<Integer> list = new ArrayList<>();
        for (int i = 100; i < 1000; i += 2) {
        	Map<Integer, Integer> map = new HashMap<>();
        	int j = i;
        	while(j > 0) {
        		int last = j % 10;
        		j /= 10;
        		map.put(last, map.getOrDefault(last, 0) + 1);
        	}
        	boolean valid = true;
        	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        		if (arr[entry.getKey()] < entry.getValue()) {
        			valid = false;
        			break;
        		}
        	}
        	if (valid) list.add(i);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
