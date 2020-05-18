package comp.prep2019;
import java.util.*;
public class Prob211 {
	/** Initialize your data structure here. */
	private Trie root;
    public Prob211() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
        	if (cur.arr[c - 'a'] == null) cur.arr[c - 'a'] = new Trie();
        	cur = cur.arr[c - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	List<Trie> list = new ArrayList<>();
    	list.add(root);
    	for (char c : word.toCharArray()) {
    		List<Trie> temp = new ArrayList<>();
    		for (Trie trie : list) {
    			if (c == '.') {
            		for (Trie t : trie.arr) {
            			if (t != null) temp.add(t);
            		}
            	} else {
            		if (trie.arr[c - 'a'] == null) continue;
            		trie = trie.arr[c - 'a'];
            		temp.add(trie);
            	}
    		}
    		list = temp;
    		if (list.isEmpty()) return false;
        }
    	for (Trie trie : list) {
    		if (trie.isWord) return true;
    	}
    	return false;
    }
    
    class Trie {
    	Trie[] arr = new Trie[26];
    	boolean isWord;
    }
    
    public static void main(String[] args) {
    	Prob211 prob = new Prob211();
    	prob.addWord("bad");
    	prob.addWord("dad");
    	prob.addWord("mad");
    	System.out.println(prob.search("pad"));
    	System.out.println(prob.search("bad"));
    	System.out.println(prob.search(".ad"));
    	System.out.println(prob.search("b.."));
    }
}
