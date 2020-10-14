package comp.prep2019.less2000;
import java.util.*;
public class Prob1258 {
	public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Set<String>> synMap = new HashMap<>();
        for (List<String> syn : synonyms) {
        	if (synMap.containsKey(syn.get(0))) {
        		synMap.get(syn.get(0)).add(syn.get(1));
        		synMap.put(syn.get(1), synMap.get(syn.get(0)));
        	} else if (synMap.containsKey(syn.get(1))) {
        		synMap.get(syn.get(1)).add(syn.get(0));
        		synMap.put(syn.get(0), synMap.get(syn.get(1)));
        	} else {
        		Set<String> set = new HashSet<>();
        		set.add(syn.get(0));
        		set.add(syn.get(1));
        		synMap.put(syn.get(0), set);
        		synMap.put(syn.get(1), set);
        	}
        }
        List<String> result = new ArrayList<>();
        dfs(text.split(" "), 0, "", synMap, result);
        Collections.sort(result);
        return result;
    }
	
	private void dfs(String[] words, int start, String temp, 
			Map<String, Set<String>> synMap, List<String> result) {
		if (start == words.length) {
			temp = temp.trim();
			result.add(temp);
			return;
		}
		if (!synMap.containsKey(words[start])) {
			dfs(words, start + 1, temp + " " + words[start], synMap, result);
			return;
		}
		for (String w : synMap.get(words[start])) {
			dfs(words, start + 1, temp + " " + w, synMap, result);
		}
	}
}
