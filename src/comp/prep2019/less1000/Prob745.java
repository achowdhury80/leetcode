package comp.prep2019.less1000;
import java.util.*;

public class Prob745 {
	Trie root;
	  Trie reverse;
	  int maxWeight = -1;
	  public Prob745(String[] words) {
	    root = new Trie();
	    reverse = new Trie();
	    for (int i = words.length - 1; i > -1; i--) {
	      add(root, reverse, words[i], i);
	    }
	    maxWeight = words.length - 1;
	  }

	  public int f(String prefix, String suffix) {
	    if ((prefix == null || prefix.length() < 1) && (suffix == null || suffix.length() < 1)) return maxWeight;
	    List<Integer> prefixList = search(root, prefix);
	    if (prefix != null && prefix.length() > 0 && prefixList == null) return -1;
	    List<Integer> suffixList = search(reverse, new StringBuilder(suffix).reverse().toString());
	    if (suffix != null && suffix.length() > 0 && suffixList == null) return -1;
	    if (prefix == null || prefix.length() < 1) return suffixList.get(0);
	    if (suffix == null || suffix.length() < 1) return prefixList.get(0);
	    for (int i = 0, j = 0; i < prefixList.size() && j < suffixList.size(); ) {
	      int pId = prefixList.get(i);
	      int sId = suffixList.get(j);
	      if (pId == sId) return prefixList.get(i);
	      if (pId > sId) i++;
	      else j++;
	    }
	    return -1;
	  }

	  private List<Integer> search(Trie root, String word) {
	    if (word == null || word.equals("")) return null;
	    Trie node = root;
	    for (int i = 0; i < word.length(); i++) {
	      char c = word.charAt(i);
	      if (node.arr[c- 'a'] == null) return null;
	      node = node.arr[c- 'a'];
	    }
	    return node.list;
	  }

	  private void add(Trie root, Trie reverse, String word, int weight) {
	    Trie node = root;
	    Trie rev = reverse;
	    for (int j = 0; j < word.length(); j++) {
	      char c1 = word.charAt(j);
	      char c2 = word.charAt(word.length() - 1 - j);
	      if (node.arr[c1 - 'a'] == null) {
	        node.arr[c1 - 'a'] = new Trie();
	      }
	      node.arr[c1 - 'a'].list.add(weight);
	      node = node.arr[c1 - 'a'];
	      if (rev.arr[c2 - 'a'] == null) {
	        rev.arr[c2 - 'a'] = new Trie();
	      }
	      rev.arr[c2 - 'a'].list.add(weight);
	      rev = rev.arr[c2 - 'a'];
	    }
	  }

	  class Trie {
	    Trie[] arr = new Trie[26];
	    List<Integer> list = new ArrayList<>();
	  }
}
