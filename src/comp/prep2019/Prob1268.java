package comp.prep2019;
import java.util.*;
public class Prob1268 {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        Trie cur;
        for (String prod : products) {
        	cur = root;
        	for (char c : prod.toCharArray()) {
        		if (cur.child[c - 'a'] == null) cur.child[c - 'a'] = new Trie();
        		cur = cur.child[c - 'a'];
        	}
        	cur.isWord = true;
        }
        List<List<String>> result = new ArrayList<>();
        cur = root;
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
        	if (cur == null) result.add(new ArrayList<>());
        	else {
        		prefix += c;
        		cur = cur.child[c - 'a'];
        		List<String> list = new ArrayList<>();
        		helper(cur, list, prefix);
        		result.add(list);
        	}
        }
        return result;
    }
	
	private void helper(Trie root, List<String> result, String prefix) {
		if (root == null) return;
		if (root.isWord) {
			result.add(prefix);
			if (result.size() == 3) return;
		}
		for (int i = 0; i < 26; i++) {
			if (root.child[i] != null) {
				helper(root.child[i], result, prefix + (char)(i + 'a'));
				if (result.size() == 3) return;
			}
		}
	}
	class Trie {
		Trie[] child = new Trie[26];
		boolean isWord = false;
	}
}
