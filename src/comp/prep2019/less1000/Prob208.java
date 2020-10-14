package comp.prep2019.less1000;

public class Prob208 {
	private Node root;
	/** Initialize your data structure here. */
    public Prob208() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] arr = word.toCharArray();
        Node cur = root;
        for (char c : arr) {
        	if (cur.child[c - 'a'] == null) cur.child[c - 'a'] = new Node();
        	cur = cur.child[c - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Node cur = root;
        char[] arr = word.toCharArray();
        for (char c : arr) {
        	if (cur.child[c - 'a'] == null) return false;
        	cur = cur.child[c - 'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        char[] arr = prefix.toCharArray();
        for (char c : arr) {
        	if (cur.child[c - 'a'] == null) return false;
        	cur = cur.child[c - 'a'];
        }
        return true;
    }
    
    class Node {
    	boolean isWord;
    	Node[] child = new Node[26];
    }
}
