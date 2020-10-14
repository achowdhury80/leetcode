package comp.prep2019;
import java.util.*;

public class Prob126 {
	public List<List<String>> findLadders(String beginWord, String endWord, 
			List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!dict.contains(endWord)) return result;
        dict.remove(beginWord);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        boolean found = false;
        Map<String, Set<String>> preWords = new HashMap<>();
        int n = beginWord.length();
        while(!q.isEmpty() && !found) {
        	int size = q.size();
        	Set<String> tempVisited = new HashSet<>();
        	for (int i = 0; i < size; i++) {
        		String cur = q.poll();
        		char[] chars = cur.toCharArray();
        		for (int j = 0; j < n; j++) {
        			char c = chars[j];
        			for (char ch = 'a'; ch <= 'z'; ch++) {
        				if (c == ch) continue;
        				chars[j] = ch;
        				String s = new String(chars);
        				if (dict.contains(s) && !visited.contains(s)) {
        					q.offer(s);
        					tempVisited.add(s);
        					Set<String> pre = preWords.getOrDefault(s, new HashSet<>());
            				pre.add(cur);
            				preWords.put(s, pre);
            				if (endWord.equals(s)) found = true;
        				}
        				chars[j] = c;
        			}
        		}
        	}
        	visited.addAll(tempVisited);
        }
        if (!found) return result;
        helper(beginWord, endWord, preWords, result, new ArrayList<>());
        return result;
    }
	
	private void helper(String beginWord, String endWord, 
			Map<String, Set<String>> preWords, List<List<String>> result, 
			List<String> path) {
		path.add(0, endWord);
		if (beginWord.equals(endWord)) {
			result.add(path);
			return;
		}
		if (preWords.get(endWord) != null) {
			for (String w : preWords.get(endWord)) {
				helper(beginWord, w, preWords, result, new ArrayList<>(path));
			}
		}
	}
	
	public static void main(String[] args) {
	    Prob126 prob126 = new Prob126();
	    System.out.println(prob126.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
	    //System.out.println(prob126.findLadders("hot", "dog", Arrays.asList(new String[]{"hot","dog"})));
	  }
	
}
