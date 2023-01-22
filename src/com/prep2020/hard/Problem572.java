package com.prep2020.hard;
import java.util.*;
public class Problem572 {
	/**
	 * Time Complexity: O(C)O(C) where CC is the number of characters across all words in the given array.

Space Complexity: O(C)O(C).
	 * @param words
	 * @return
	 */
	public List<String> wordsAbbreviation(List<String> words) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        Set<String> problemKey = new HashSet<>();
        for (int i = 0; i < words.size(); i++) {
        	String key = findAbbv(words.get(i));
        	if (map.containsKey(key)) {
        		List<Integer> list = map.get(key);
        		list.add(i);
        		problemKey.add(key);
        	} else {
        		List<Integer> list = new ArrayList<>();
        		list.add(i);
        		map.put(key, list);
        	}
        	result.add(key);
        }
        if (!problemKey.isEmpty()) {
        	for (String key : problemKey) {
        		Map<Integer, String> abbvMap = findAbbv(words, map.get(key));
        		for (Map.Entry<Integer, String> entry : abbvMap.entrySet()) {
        			result.set(entry.getKey(), entry.getValue());
        		}
        	}
        }
        return result;
    }
	
	private Map<Integer, String> findAbbv(List<String> words, List<Integer> list) {
		Trie root = new Trie();
		for (int i : list) {
			String w = words.get(i);
			Trie cur = root;
			cur.wordIndices.add(i);
			for (char c : w.toCharArray()) {
				if (cur.arr[c - 'a'] == null) {
					cur.arr[c - 'a'] = new Trie();
				}
				cur = cur.arr[c - 'a'];
				cur.wordIndices.add(i);
			}
			cur.isEnd = true;
		}
		Queue<Trie> q = new LinkedList<>();
		q.offer(root);
		int level = -1;
		Map<Integer, String> result = new HashMap<>();
		while(!q.isEmpty()) {
			int size = q.size();
			level++;
			for (int i = 0; i < size; i++) {
				Trie cur = q.poll();
				if (cur.isEnd) {
					int index = cur.wordIndices.get(0);
					result.put(index, words.get(index));
				} else if (cur.wordIndices.size() == 1) {
					int index = cur.wordIndices.get(0);
					if (words.get(index).length() > level + 2) {
						String w = words.get(index);
						result.put(index, w.substring(0, level) + (w.length() - level - 1) + w.substring(w.length() - 1));
					} else result.put(index, words.get(index));
				} else {
					for (int j = 0; j < 26; j++) {
						if (cur.arr[j] != null) {
							q.offer(cur.arr[j]);
						}
					}
				}
			}
		}
		return result;
	}

	private String findAbbv(String w) {
		int n;
		if ((n = w.length()) < 4) return w;
		return "" + w.charAt(0) + (n - 2) + w.charAt(n - 1);
	}
	
	class Trie {
		Trie[] arr = new Trie[26];
		List<Integer> wordIndices = new ArrayList<>();
		boolean isEnd;
	}
	
	public static void main(String[] args) {
		Problem572 problem = new Problem572();
		System.out.println(problem.wordsAbbreviation(Arrays.asList("like","god","internal","me","internet","interval","intension","face","intrusion")));
	}
}
