package com.leet.algo;
import java.util.*;
public class Prob1125 {
	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
        	skillMap.put(req_skills[i], i);
        }
        Map<Integer, List<Integer>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());
        for (int i = 0; i < people.size(); i++) {
        	int hisSkill = 0;
        	for (String skill : people.get(i)) {
        		if(skillMap.containsKey(skill)) {
        			hisSkill |= (1 << skillMap.get(skill));
        		}
        	}
        	// to avoid concurrent modification exception
        	Map<Integer, List<Integer>> newMap = new HashMap<>(dp);
        	for (Map.Entry<Integer, List<Integer>> entry : dp.entrySet()) {
        		int withHim = entry.getKey() | hisSkill;
        		if (withHim == entry.getKey()) continue;
        		if (!newMap.containsKey(withHim) || newMap.get(withHim).size() > entry.getValue(). size() + 1) {
        			List<Integer> list = new ArrayList<>();
        			list.addAll(entry.getValue());
        			list.add(i);
        			newMap.put(withHim, list);
        		}
        	}
        	dp = newMap;
        	
        }
        List<Integer> list =  dp.get((1 << req_skills.length) - 1);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
