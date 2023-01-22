package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2115 {
	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> indeg = new HashMap<>();
        Map<String, Set<String>> depends = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<String>();
        for (int i = 0; i < recipes.length; i++) {
        	boolean missing = false;
        	for (String ingred : ingredients.get(i)) {
        		if (!set.contains(ingred)) {
        			missing = true;
        			Set<String> next = depends.getOrDefault(ingred, new HashSet<>());
        			next.add(recipes[i]);
        			depends.put(ingred, next);
        			indeg.put(recipes[i], indeg.getOrDefault(recipes[i], 0) + 1);
        		}
        	}
        	if (!missing) q.offer(recipes[i]);
        }
        while(!q.isEmpty()) {
        	String cur = q.poll();
        	result.add(cur);
        	if (depends.containsKey(cur)) {
        		for (String r : depends.get(cur)) {
        			indeg.put(r, indeg.get(r) - 1);
        			if (indeg.get(r) == 0) q.offer(r);
        		}
        	}
        }
        return result;
    }
}
