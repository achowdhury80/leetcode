package comp.prep2019;

public class Prob676 {
	private Trie root;
	/** Initialize your data structure here. */
    public Prob676() {
        root = new Trie();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
        	Trie cur = root;
        	for (char c : s.toCharArray()) {
        		if (cur.child[c - 'a'] == null) cur.child[c - 'a'] = new Trie();
        		cur = cur.child[c - 'a'];
        	}
        	cur.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
    	if(word == null || word.length() < 1) return false;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++){
          for(char c = 'a'; c <= 'z'; c++){
            if(chars[i] == c) continue;
            char orig = chars[i];
            chars[i] = c;
            if(findExact(root, chars)) return true;
            chars[i] = orig;
          }
        }
        return false;
    }
    
    private boolean findExact(Trie trie, char[] arr) {
    	for (char c : arr) {
    		if (trie.child[c - 'a'] == null) return false;
    		trie = trie.child[c - 'a'];
    	}
    	return trie.isWord;
    }
    
    class Trie {
    	Trie[] child = new Trie[26];
    	boolean isWord;
    }
}
