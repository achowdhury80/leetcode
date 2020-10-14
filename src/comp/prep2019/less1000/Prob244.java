package comp.prep2019.less1000;
import java.util.*;
public class Prob244 { 
	private Map<String, List<Integer>> map;
	public Prob244(String[] words) {
		map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
			list.add(i);
			map.put(words[i], list);
		}
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int i = 0, j = 0;
        int result = Integer.MAX_VALUE;
        while(i < l1.size() && j < l2.size()) {
        	result = Math.min(result, Math.abs(l1.get(i) - l2.get(j)));
        	if (l1.get(i) < l2.get(j)) i++;
        	else j++;
        }
        return result;
    }
}
