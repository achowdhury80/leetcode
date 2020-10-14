package comp.prep2019.less1000;
import java.util.*;
public class Prob727 {
	/**
	 * O(ST) time and O(S) space
	 * Find indices of different characters of T in S and keep in 
	 * List<Integer>[] indices
	 * for first character, get the list indices and put in treeMap
	 * this Treemap maintains an interval where key is end index and value is start
	 * index.
	 * for every subsequent character of T, for each index find the nearest lower 
	 * index from TreeMap. If found, a new interval is created where key is the new 
	 * character index and value is the lower intervals value. Put these interval
	 * in a new map. once done with all index, swap the new treeMap with old TreeMap.
	 * At the end, loop through the treeMap to find the smallest interval
	 * @param S
	 * @param T
	 * @return
	 */
	public String minWindow(String S, String T) {
        List<Integer>[] indices = new List[26];
        for (char c : T.toCharArray()) {
        	if (indices[c - 'a'] == null) indices[c - 'a'] = new ArrayList<>();
        }
        for (int i = 0; i < S.length(); i++) {
        	int idx = S.charAt(i) - 'a';
        	if (indices[idx] != null) indices[idx].add(i);
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : indices[T.charAt(0) - 'a']) {
        	treeMap.put(i,  i);
        }
        for (int i = 1; i < T.length(); i++) {
        	if (treeMap.isEmpty()) return "";
        	treeMap = findIntervals(treeMap, indices[T.charAt(i) - 'a']);
        }
        if (treeMap.isEmpty()) return "";
        Map.Entry<Integer, Integer> smallest = null;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
        	if (smallest == null || (entry.getKey() - entry.getValue()) 
        			< (smallest.getKey() - smallest.getValue())) 
        		smallest = entry;
        }
        return S.substring(smallest.getValue(), smallest.getKey() + 1);
    }
	
	private TreeMap<Integer, Integer> findIntervals(
			TreeMap<Integer, Integer> lastMap, List<Integer> indices) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (int i : indices) {
			Map.Entry<Integer, Integer> entry = lastMap.lowerEntry(i);
			if (entry == null) continue;
			treeMap.put(i, entry.getValue());
		}
		return treeMap;
	}
}
