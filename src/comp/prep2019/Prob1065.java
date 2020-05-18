package comp.prep2019;

import java.util.PriorityQueue;

public class Prob1065 {
	/**
	 * create trie using all words
	 * form the text, starting from ith character search the trie for a match
	 * i = 0... ext.length
	 * @param text
	 * @param words
	 * @return
	 */
	public int[][] indexPairs(String text, String[] words) {
		Trie root = new Trie();
        for (String w : words) {
        	Trie cur = root;
        	for (char c : w.toCharArray()) {
        		if (cur.tries[c - 'a'] == null) cur.tries[c - 'a'] = new Trie();
        		cur = cur.tries[c - 'a'];
        	}
        	cur.isEnd = true;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0] == y[0] ? (x[1] - y[1]) : (x[0] - y[0])));
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	Trie cur = root;
        	for (int j = i; j < arr.length; j++) {
        		char c = arr[j];
        		if (cur.tries[c - 'a'] == null) break;
        		cur = cur.tries[c - 'a'];
        		if (cur.isEnd) {
        			pq.offer(new int[] {i, j});
        		}
        	}
        }
        int[][] result = new int[pq.size()][];
        int size = pq.size();
        for (int i = 0; i < size; i++) {
        	result[i] = pq.poll();
        }
        return result;
        
    }
	
	class Trie {
		Trie[] tries = new Trie[26];
		boolean isEnd;
	}
}
