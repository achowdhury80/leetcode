package com.prep2020.medium;
import java.util.*;
public class Problem1257 {
	public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> map = new HashMap<>();
        for (List<String> region : regions) {
        	for (int i = 1; i < region.size(); i++) map.put(region.get(i), region.get(0));
        }
        Set<String> region1Parent = new HashSet<>();
        String cur = region1;
        region1Parent.add(cur);
        while(map.containsKey(cur)) {
        	region1Parent.add(map.get(cur));
        	cur = map.get(cur);
        }
        cur = region2;
        if (region1Parent.contains(region2)) return region2;
        while(map.containsKey(cur)) {
        	cur = map.get(cur);
        	if (region1Parent.contains(cur)) return cur;
        }
        return null;
    }
}
