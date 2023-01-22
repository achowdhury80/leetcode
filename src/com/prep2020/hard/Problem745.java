package com.prep2020.hard;
import java.util.*;
/**
 * https://leetcode.com/problems/prefix-and-suffix-search/solution/
 * @author aychowdh
 *
 */
public class Problem745 {
	private Trie root;
	public Problem745(String[] words) {
		root = new Trie();
        for (int weight = 0; weight < words.length; ++weight) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); ++i) {
                Trie cur = root;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; ++j) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.arr[k] == null)
                        cur.arr[k] = new Trie();
                    cur = cur.arr[k];
                    cur.weight = weight;
                }
            }
        }
    }
    public int f(String prefix, String suffix) {
        Trie cur = root;
        for (char letter: (suffix + '{' + prefix).toCharArray()) {
            if (cur.arr[letter - 'a'] == null) return -1;
            cur = cur.arr[letter - 'a'];
        }
        return cur.weight;
    }

	class Trie {
    	Trie[] arr = new Trie[26];
    	int weight;
    }
}
