package com.leet.algo;
import java.util.*;
public class Prob472 {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
       List<String> result = new ArrayList<>();
       Set<String> cache = new HashSet<>();
       cache.addAll(Arrays.asList(words));
       for (String word : words) {
    	   if (substringExists(word, 0, cache, false)) result.add(word);
       }
       return result;
    }
	
	private boolean substringExists(String word, int start, Set<String> cache, boolean includeLast) {
		for (int i = start + 1; i < word.length() + (includeLast ? 1 : 0); i++) {
			if (cache.contains(word.substring(start, i)) 
					&& (i == word.length() || substringExists(word, i, cache, true))) {
				return true;
			}
		}
		return false;
	}
}
