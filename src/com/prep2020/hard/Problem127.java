package com.prep2020.hard;
import java.util.*;
public class Problem127 {
	/**
	 * if n = wordlist.length then O(N) time and space
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int result = 1;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		String w = q.poll();
        		for (int j = 0; j < w.length(); j++) {
        			char c = w.charAt(j);
        			for (int k = 0; k < 26; k++) {
        				char ch = (char)('a' + k);
        				if (c == ch) continue;
        				String newWord = w.substring(0, j) + ch + w.substring(j + 1);
        				if (newWord.equals(endWord)) return result;
        				if (set.contains(newWord) && !visited.contains(newWord)) {
        					visited.add(newWord);
        					q.offer(newWord);
        				}
        			}
        		}
        	}
        }
        return 0;
    }
}
