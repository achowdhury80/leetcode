package comp.prep2019.less1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob734 {
	public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
	    if(words1 == null || words2 == null || words1.length != words2.length) return false;
	    if(words1.length == 0) return true;
	    Map<String, List<String>> wordMap = new HashMap<>();
	    for (List<String> pair : pairs) {
	    	if (!wordMap.containsKey(pair.get(0))) {
		        wordMap.put(pair.get(0), new ArrayList<>());
		      }
		      if (!wordMap.containsKey(pair.get(1))) {
		        wordMap.put(pair.get(1), new ArrayList<>());
		      }
		      wordMap.get(pair.get(0)).add(pair.get(1));
		      wordMap.get(pair.get(1)).add(pair.get(0));
	    }
	    
	    for(int i = 0; i < words1.length; i++){

	      if(!words1[i].equals(words2[i]) && !mapContainsSimilarity(wordMap, words1[i], words2[i])) return false;

	    }
	    return true;
	  }

	  private boolean mapContainsSimilarity(Map<String, List<String>> wordMap, String word1, String word2){
	    if(wordMap.get(word1) != null && wordMap.get(word1).contains(word2)) return true;
	    if(wordMap.get(word2) != null && wordMap.get(word2).contains(word1)) return true;
	    return false;
	  }
}
