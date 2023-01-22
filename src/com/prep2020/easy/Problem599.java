package com.prep2020.easy;
import java.util.*;
public class Problem599 {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list2.length; i++) map.put(list2[i], i);
		Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] + x[1] - y[0] - y[1]);
        for (int i = 0; i < list1.length; i++) {
        	if (map.containsKey(list1[i])) {
        		q.offer(new int[] {i, map.get(list1[i])});
        	}
        }
        int[] idx = q.poll();
        int minSum = idx[0] + idx[1];
        List<String> list = new ArrayList<>();
        list.add(list1[idx[0]]);
        while(!q.isEmpty()) {
        	idx = q.poll();
        	if (idx[0] + idx[1] > minSum) break;
        	list.add(list1[idx[0]]);
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
