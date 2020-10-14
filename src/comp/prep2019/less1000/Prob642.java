package comp.prep2019.less1000;
import java.util.*;

public class Prob642 {
	class TrieNode {
	    Map<Character, TrieNode> children = new HashMap<>();
	    Map<String, Integer> counts = new HashMap<>();
	    boolean end;
	  }

	  class Pair {
	    String word;
	    int count;
	    Pair(String word, int count) {
	      this.word = word;
	      this.count = count;
	    }
	  }

	  private TrieNode root;
	  private String prefix;
	  public Prob642(String[] sentences, int[] times) {
	    root = new TrieNode();
	    prefix = "";
	    for (int i = 0; i < sentences.length; i++) add(sentences[i], times[i]);
	  }

	  private void add(String sentence, int times) {
	    TrieNode node = root;
	    for (int j = 0; j < sentence.length(); j++) {
	      char c = sentence.charAt(j);
	      if (!node.children.containsKey(c)) node.children.put(c, new TrieNode());
	      node = node.children.get(c);
	      node.counts.put(sentence, node.counts.getOrDefault(sentence, 0) + times);
	    }
	    node.end = true;
	  }

	  public List<String> input(char c) {
	    if (c == '#') {
	      add(prefix, 1);
	      prefix = "";
	      return new ArrayList<String>();
	    }

	    prefix = prefix + c;
	    TrieNode curr = root;
	    for (char cc : prefix.toCharArray()) {
	      TrieNode next = curr.children.get(cc);
	      if (next == null) {
	        return new ArrayList<String>();
	      }
	      curr = next;
	    }

	    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count));
	    for (String s : curr.counts.keySet()) {
	      pq.add(new Pair(s, curr.counts.get(s)));
	    }

	    List<String> res = new ArrayList<String>();
	    for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
	      res.add(pq.poll().word);
	    }
	    return res;
	  }
    
    public static void main(String[] args) {
        Prob642 prob642 = null;
        prob642 = new Prob642(new String[]{"i love you", "island","ironman", "i love leetcode"}, new int[]{5,3,2,2});
        System.out.println(prob642.input('i'));
        System.out.println(prob642.input(' '));
        System.out.println(prob642.input('a'));
        System.out.println(prob642.input('#'));
        System.out.println(prob642.input('i'));
        System.out.println(prob642.input(' '));
        System.out.println(prob642.input('a'));
        System.out.println(prob642.input('#'));
        System.out.println(prob642.input('i'));
        System.out.println(prob642.input(' '));
        System.out.println(prob642.input('a'));
        System.out.println(prob642.input('#'));
        
    }
}
