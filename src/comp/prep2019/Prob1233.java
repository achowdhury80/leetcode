package comp.prep2019;
import java.util.*;
public class Prob1233 {
	public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        Trie cur = root;
        for (String f : folder) {
        	String[] arr = f.split("/");
        	cur = root;
        	boolean flag = false;
        	for (String s: arr) {
        		if ("".equals(s)) continue;
        		if (cur.childMap.containsKey(s)) {
        			cur = cur.childMap.get(s);
        			if (cur.isComplete) {
        				flag = true;
        				break;
        			}
        		} else {
        			cur.childMap.put(s, new Trie());
        			cur = cur.childMap.get(s);
        		}
        	}
        	if(!flag) cur.isComplete = true;
        }
        cur = root;
    	List<String> result = new ArrayList<>();
    	dfs(cur, "", result);
    	return result;
    }
	class Trie {
		Map<String, Trie> childMap = new HashMap<>();
		boolean isComplete;
	}
	
	private void dfs(Trie cur, String path, List<String> result) {
		if(cur.isComplete) {
			result.add(path);
			return;
		}
		for (String key : cur.childMap.keySet()) {
			dfs(cur.childMap.get(key), path + "/" + key, result);
		}
	}
	
	public static void main(String[] args) {
		Prob1233 prob = new Prob1233();
		System.out.println(prob.removeSubfolders(new String[] {"/a","/a/b","/c/d","/c/d/e","/c/f"}));
	}
}
