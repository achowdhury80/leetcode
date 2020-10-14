package comp.prep2019.less1000;
import java.util.*;
public class Prob737 {
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, 
			List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        if (words1.length == 0) return true;
		Map<String, String> parentMap = new HashMap<>();
        for (List<String> pair : pairs) {
        	String p1 = findNAddParent(parentMap, pair.get(0));
        	String p2 = findNAddParent(parentMap, pair.get(1));
        	if (!p1.equals(p2)) {
        		if (p1.compareTo(p2) < 0) {
        			parentMap.put(p2, p1);
        		} else parentMap.put(p1, p2);
        	}
        }
        for (int i = 0; i < words1.length; i++) {
        	if (!words1[i].equals(words2[i])) {
        		String p1 = findNAddParent(parentMap,words1[i]);
            	String p2 = findNAddParent(parentMap, words2[i]);
            	if (!p1.equals(p2)) return false;
        	}
        }
        return true;
    }
	
	private String findNAddParent(Map<String, String> parentMap, String w) {
		if (!parentMap.containsKey(w)) {
			parentMap.put(w, w);
			return w;
		}
		while(!parentMap.get(w).equals(w)) w = parentMap.get(w);
		return w;
	}
}
