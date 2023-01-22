package com.prep2020.medium;
import java.util.*;
public class Problem244 {
	private Map<String, List<Integer>> map;
	public Problem244(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
        	List<Integer> list = map.getOrDefault(wordsDict[i], new ArrayList<>());
        	list.add(i);
        	map.put(wordsDict[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
    	List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int i = 0, j = 0;
        int result = Integer.MAX_VALUE;
        while(i < l1.size() && j < l2.size()) {
        	result = Math.min(result, Math.abs(l1.get(i) - l2.get(j)));
        	if (l1.get(i) < l2.get(j)) i++;
        	else j++;
        }
        return result;
    }
}
