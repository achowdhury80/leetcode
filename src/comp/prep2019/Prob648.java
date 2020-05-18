package comp.prep2019;
import java.util.*;
public class Prob648 {
	public String replaceWords(List<String> dict, String sentence) {
        Trie root = new Trie();
        populate(root, dict);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
        	result.append(findRoot(root, word));
        	result.append(" ");
        }
        return result.substring(0, result.length() - 1);
    }
	
	private String findRoot(Trie root, String word) {
		char[] arr = word.toCharArray();
		Trie cur = root;
		StringBuilder sb = new StringBuilder();
		for (char c : arr) {
			if (cur.next[c - 'a'] != null) {
				sb.append(c);
				cur = cur.next[c - 'a'];
				if (cur.isEnd) {
					return sb.toString();
				}
			} else {
				return word;
			}
		}
		return word;
	}
	
	private void populate(Trie root, List<String> dict) {
		for (String word : dict) {
			char[] arr = word.toCharArray();
			Trie cur = root;
			for (char c : arr) {
				if (cur.next[c - 'a'] != null) {
					cur = cur.next[c - 'a'];
					if (cur.isEnd) break;
				} else {
					cur.next[c - 'a'] = new Trie();
					cur = cur.next[c - 'a'];
				}
			}
			cur.isEnd = true;
		}
	}
	
	class Trie {
		Trie[] next = new Trie[26];
		boolean isEnd;
	}
}
