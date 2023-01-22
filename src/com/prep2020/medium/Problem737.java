package com.prep2020.medium;
import java.util.*;
public class Problem737 {
	public boolean areSentencesSimilarTwo(String[] sentence1, 
			String[] sentence2, List<List<String>> similarPairs) {
		if (sentence1.length != sentence2.length) return false;
        Map<String, String> parents = new HashMap<>();
        for (List<String> similar : similarPairs) {
        	Collections.sort(similar);
        	if (!parents.containsKey(similar.get(0)))
        		parents.put(similar.get(0), similar.get(0));
        	if (!parents.containsKey(similar.get(1)))
        		parents.put(similar.get(1), similar.get(1));
        	String parent1 = findParent(similar.get(0), parents);
        	String parent2 = findParent(similar.get(1), parents);
        	if (!parent1.equals(parent2)) {
        		if (parent1.compareTo(parent2) < 0) 
        			parents.put(parent2, parent1);
        		else parents.put(parent1, parent2);
        	}
        }
        
        for(int i = 0; i < sentence1.length; i++) {
        	if (sentence1[i].equals(sentence2[i])) continue;
        	String parent1 = findParent(sentence1[i], parents);
        	if (parent1 == null) return false;
        	String parent2 = findParent(sentence2[i], parents);
        	if (parent2 == null || !parent1.equals(parent2)) return false;
        }
        return true;
    }

	private String findParent(String s, Map<String, String> parents) {
		if (!parents.containsKey(s)) return null;
		while(s != parents.get(s)) {
			s = parents.get(s);
		}
		return s;
	}
}
