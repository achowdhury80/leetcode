package comp.prep2019.less1000;
import java.util.*;
public class Prob425 {
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> result = new ArrayList<>();
		Trie root = buildTrie(words);
		helper(words, new ArrayList<>(), new boolean[words.length], root, result);
		return result;
    }
	
	private void helper(String[] words, List<String> cur, boolean[] used, Trie root, 
			List<List<String>> result) {
		 if (cur.size() == words[0].length()) {
			 result.add(new ArrayList<>(cur));
			 return;
		 }
		 String prefix = createPrefix(cur);
		 List<Integer> index = findStringStartsWith(root, prefix);
		 for (int i : index) {
			 used[i] = true;
			 cur.add(words[i]);
			 helper(words, cur, used, root, result);
			 cur.remove(cur.size() - 1);
			 used[i] = false;
		 }
	}
	
	private String createPrefix(List<String> cur) {
		String prefix = "";
		int n = cur.size();
		for (int i = 0; i < n; i++) {
			prefix += cur.get(i).charAt(n);
		}
		return prefix;
	}
	
	private Trie buildTrie(String[] words) {
		Trie root = new Trie();
		for (int i = 0; i < words.length; i++) {
			Trie cur = root;
			char[] arr = words[i].toCharArray();
			cur.addIndex(i);
			for (char c : arr) {
				int idx = c - 'a';
				if (cur.arr[idx] == null) {
					cur.arr[idx] = new Trie();
				}
				cur = cur.arr[idx];
				cur.addIndex(i);
			}
		}
		return root;
	}
	
	private List<Integer> findStringStartsWith(Trie root, String prefix) {
		if (prefix.equals("")) return root.indices;
		Trie cur = root;
		for (char c : prefix.toCharArray()) {
			int idx = c - 'a';
			if (cur.arr[idx] == null) return new ArrayList<>();
			cur = cur.arr[idx];
		}
		return cur.indices;
	}
	
	class Trie {
		private Trie[] arr = new Trie[26];
		private List<Integer> indices = new ArrayList<>();
		void addIndex(int idx) {
			indices.add(idx);
		}
	}
	
	public static void main(String[] args) {
		Prob425 prob = new Prob425();
		System.out.println(prob.wordSquares(new String[] {"area","lead","wall","lady","ball"}));
	}
}
