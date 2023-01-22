package com.prep2020.medium;
import java.util.*;
public class Problem1452 {
	public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
        	for (String s : favoriteCompanies.get(i)) {
        		Set<Integer> set = map.getOrDefault(s, new HashSet<>());
        		set.add(i);
        		map.put(s, set);
        	}
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
        	List<String> companies = favoriteCompanies.get(i);
        	Set<Integer> indices = new HashSet<>(map.get(companies.get(0)));
        	if (companies.size() == 1 && indices.size() == 1) result.add(i);
        	for (int j = 1; j < companies.size(); j++) {
        		Set<Integer> nextSet = new HashSet<>(map.get(companies.get(j)));
        		nextSet.retainAll(indices);
        		if (nextSet.size() == 1) {
        			result.add(i);
        			break;
        		} else indices = nextSet;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1452 problem = new Problem1452();
		System.out.println(problem.peopleIndexes(Arrays.asList(
				Arrays.asList("leetcode","google","facebook"), 
				Arrays.asList("google","microsoft"),
				Arrays.asList("google","facebook"),
				Arrays.asList("google"),
				Arrays.asList("amazon"))));
	}
}
