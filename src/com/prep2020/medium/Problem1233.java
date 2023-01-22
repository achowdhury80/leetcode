package com.prep2020.medium;
import java.util.*;
public class Problem1233 {
	public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for (String f : folder) {
        	String[] arr = f.substring(1).split("/");
        	Trie cur = root;
        	boolean found = false;
        	for (String a : arr) {
        		if (!cur.map.containsKey(a)) cur.map.put(a, new Trie());
        		cur = cur.map.get(a);
        		if (cur.isDir) {
        			found = true;
        			break;
        		}
        	}
        	if (!found) {
        		cur.isDir = true;
        		cur.map = null;
        	}
        }
        List<String> result = new ArrayList<>();
        dfs(root, result, "");
        return result;
    }
	private void dfs(Trie cur, List<String> result, String path) {
		if (cur.isDir) {
			result.add(path);
			return;
		}
		for (Map.Entry<String, Trie> entry : cur.map.entrySet()) {
			String newPath = path + "/" + entry.getKey();
			dfs(entry.getValue(), result, newPath);
		}
		
	}
	class Trie {
		Map<String, Trie> map = new HashMap<>();
		boolean isDir;
	}
	
	public static void main(String[] args) {
		Problem1233 problem = new Problem1233();
		System.out.println(problem.removeSubfolders(new String[] {"/a","/a/b","/c/d","/c/d/e","/c/f"}));
	}
}
