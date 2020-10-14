package comp.prep2019.less1000;
import java.util.*;
public class Prob966 {
	public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, String> exactMatchMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        for (String w : wordlist) {
        	exactMatchMap.put(w, w);
        	String lower = w.toLowerCase();
        	if (!map.containsKey(lower)) {
        		map.put(lower, w);
        	}
        	String vowelLess = findVowelLessWord(lower);
        	if (!map.containsKey(vowelLess)) map.put(vowelLess, w);
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	String q = queries[i];
        	String vowelLess = "", lower = "";
        	if (exactMatchMap.containsKey(q)) result[i] = exactMatchMap.get(q);
        	else if (map.containsKey((lower = q.toLowerCase()))) result[i] = map.get(lower);
        	else if (map.containsKey((vowelLess = findVowelLessWord(lower)))) result[i] = map.get(vowelLess);
        	else result[i] = "";
        }
        return result;
    }
	
	private String findVowelLessWord(String lower) {
		StringBuilder sb = new StringBuilder();
		for (char c : lower.toCharArray()) {
			if ("aeiou".indexOf(c) > -1) sb.append('_');
			else sb.append(c);
		}
		return sb.toString();
	}
}
