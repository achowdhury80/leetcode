package comp.prep2019.less2000;
import java.util.*;
public class Prob1032 {
	private int k = 1;
	private List<Character> list;
	private Trie root;
	public Prob1032(String[] words) {
        list = new ArrayList<>();
        root = new Trie();
        for (String w : words) {
        	Trie cur = root;
        	k = Math.max(k, w.length());
        	for (int i = w.length() - 1; i > -1; i--) {
        		char c = w.charAt(i);
        		if (cur.arr[c - 'a'] == null) cur.arr[c - 'a'] = new Trie();
        		cur = cur.arr[c - 'a'];
        	}
        	cur.isWord = true;
        }
        
    }
    
    public boolean query(char letter) {
        list.add(0, letter);
        if (list.size() > k) list.remove(list.size() - 1);
        Trie cur = root;
        for (int i = 0; i < list.size(); i++) {
        	int idx = list.get(i) - 'a';
        	if (cur.arr[idx] == null) return false;
        	cur = cur.arr[idx];
        	if (cur.isWord) return true;
        }
        return false;
    }
    
    class Trie {
    	Trie[] arr = new Trie[26];
    	boolean isWord;
    }
}
