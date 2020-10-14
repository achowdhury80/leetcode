package comp.prep2019.less1000;
import java.util.*;
public class Prob677 {
	private Trie root;
	public Prob677() {
        root = new Trie();
    }
    
    public void insert(String key, int val) {
        Trie cur = root;
        for (char c : key.toCharArray()) {
        	if (!cur.map.containsKey(c))cur.map.put(c, new Trie());
        	cur = cur.map.get(c);
        }
        cur.isWord = true;
        cur.val = val;
    }
    
    public int sum(String prefix) {
    	Trie cur = root;
        for (char c : prefix.toCharArray()) {
        	if (!cur.map.containsKey(c)) return 0;
        	cur = cur.map.get(c);
        }
        int[] result = new int[] {0};
        dfs(cur, result);
        return result[0];
    }
    
    private void dfs (Trie cur, int[] result) {
    	if (cur.isWord) result[0] += cur.val;
    	for (char key : cur.map.keySet()) {
    		dfs(cur.map.get(key), result);
    	}
    }
    
    class Trie {
    	Map<Character, Trie> map = new HashMap<>();
    	private int val;
    	private boolean isWord;
    }
    
    public static void main(String[] args) {
    	Prob677 prob = new Prob677();
    	prob.insert("apple",3);
    	System.out.println(prob.sum("ap"));
    	prob.insert("app",2);
    	System.out.println(prob.sum("ap"));
    }
}
