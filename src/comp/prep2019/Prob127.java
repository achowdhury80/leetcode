package comp.prep2019;
import java.util.*;
public class Prob127 {
	public int ladderLength(String beginWord, String endWord, 
			 List<String> wordList) {
		  Set<String> set = new HashSet<>(wordList);
		  int wSize = beginWord.length();
	      if (!set.contains(endWord)) return 0;
	      int result = 1;
	      Queue<String> q = new LinkedList<>();
	      q.offer(beginWord);
	      Set<String> visited = new HashSet<>();
	      visited.add(beginWord);
	      while(!q.isEmpty()) {
	    	  result++;
	    	  int size = q.size();
	    	  for (int i = 0; i < size; i++) {
	    		  String w = q.poll();
	    		  for (int j = 0; j < wSize; j++) {
	    			  char c = w.charAt(j);
	    			  for (int k = 0; k < 26; k++) {
	    				  char ch = (char)(k + 'a');
	    				  if (c != ch) {
	    					  String s = (j > 0 ? w.substring(0, j) : "") + ch + (j < wSize - 1 ? w .substring(j + 1) : "");
	    					  if (endWord.equals(s)) return result;
	    					  if (visited.contains(s) || !set.contains(s)) continue;
	    					  q.offer(s);
	    					  visited.add(s);
	    				  }
	    			  }
	    		  }
	    	  }
	      }
	      return 0;
	 }
}
