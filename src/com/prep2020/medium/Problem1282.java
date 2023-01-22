package com.prep2020.medium;
import java.util.*;
public class Problem1282 {
	/**
	 * O(N)
	 * @param groupSizes
	 * @return
	 */
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		int n = groupSizes.length;
		// map of size to list of people
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
        	list.add(i);
        	map.put(groupSizes[i], list);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        	List<Integer> people = entry.getValue();
        	List<Integer> group = new ArrayList<>();
        	while(people.size() > 0) {
        		for (int i = 0; i < entry.getKey(); i++) {
        			group.add(people.remove(0));
        		}
        		result.add(group);
        		group = new ArrayList<>();
        	}
        }
        return result;
    }

}
