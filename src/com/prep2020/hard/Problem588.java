package com.prep2020.hard;
import java.util.*;
public class Problem588 {
	private Trie root;
	public Problem588() {
        root = new Trie();
    }
    
    public List<String> ls(String path) {
    	Trie cur = root;
    	List<String> result = new ArrayList<>();
    	path = path.substring(1);
    	String[] arr = null;
        if (!"".equals(path)) {
        	arr = path.split("/");
            for (String s : arr) {
            	cur = cur.map.get(s);
            }
        }
        if (cur.content != null) {
        	result.add(arr[arr.length - 1]);
        } else if (!cur.map.isEmpty()) {
    		for (Map.Entry<String, Trie> entry : cur.map.entrySet()) {
    			result.add(entry.getKey());
        	}
    	}
        Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
    	String[] arr = path.substring(1).split("/");
        Trie cur = root;
        for (String s : arr) {
        	if (!cur.map.containsKey(s)) cur.map.put(s, new Trie());
        	cur = cur.map.get(s);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
    	String[] arr = filePath.substring(1).split("/");
        Trie cur = root;
        for (String s : arr) {
        	if (!cur.map.containsKey(s)) cur.map.put(s, new Trie());
        	cur = cur.map.get(s);
        }
        cur.content = cur.content == null ? content : (cur.content + content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] arr = filePath.substring(1).split("/");
        Trie cur = root;
        for (String s : arr) {
        	cur = cur.map.get(s);
        }
        return cur.content;
    }
    
    class Trie {
    	Map<String, Trie> map = new HashMap<>();
    	String content;
    }
    
    public static void main(String[] args) {
    	Problem588 problem = new Problem588();
    	/*System.out.println(problem.ls("/"));
    	problem.mkdir("/a/b/c");
    	System.out.println(problem.ls("/a/b"));*/
    	problem.mkdir("/goowmfn");
    	System.out.println(problem.ls("/goowmfn"));
    	System.out.println(problem.ls("/"));
    	problem.mkdir("/z");
    	System.out.println(problem.ls("/"));
    	System.out.println(problem.ls("/"));
    	problem.addContentToFile("/goowmfn/c","shetopcy");
    	System.out.println(problem.ls("/z"));
    	System.out.println(problem.ls("/goowmfn/c"));
    	System.out.println(problem.ls("/goowmfn"));
    }
}
