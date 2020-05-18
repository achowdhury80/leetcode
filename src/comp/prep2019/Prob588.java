package comp.prep2019;
import java.util.*;
public class Prob588 {
	private Trie root;
	private Map<Trie, String> fileContents;
 	public Prob588() {
        root = new Trie("/", false);
        fileContents = new HashMap<>();
    }
    
    public List<String> ls(String path) {
        List<String> pathTokens = pathList(path);
        Trie cur = root;
        for (String st : pathTokens) {
    		cur = cur.map.get(st);
    	}
        List<String> result = new ArrayList<>();
        if (cur.isFile) {
        	result.add(cur.name);
        	return result;
        }
        for (Trie trie : cur.map.values()) {
        	result.add(trie.name);
        }
        Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
    	List<String> pathTokens = pathList(path);
        Trie cur = root;
        for (String st : pathTokens) {
    		if (!cur.map.containsKey(st)) {
    			cur.map.put(st,  new Trie(st, false));
    		}
    		cur = cur.map.get(st);
    	}
    }
    
    public void addContentToFile(String filePath, String content) {
    	List<String> pathTokens = pathList(filePath);
        Trie cur = root;
        for (String st : pathTokens) {
    		if (!cur.map.containsKey(st)) {
    			cur.map.put(st,  new Trie(st, false));
    		}
    		cur = cur.map.get(st);
    	}
        cur.isFile = true;
        fileContents.put(cur, fileContents.getOrDefault(cur, "") + content);
    }
    
    public String readContentFromFile(String filePath) {
    	List<String> pathTokens = pathList(filePath);
        Trie cur = root;
        for (String st : pathTokens) {
    		cur = cur.map.get(st);
    	}
        return fileContents.get(cur);
    }
    
    class Trie {
    	String name;
    	Map<String, Trie> map = new HashMap<>();
    	boolean isFile;
    	Trie(String name, boolean isFile) {
    		this.name = name;
    		this.isFile = isFile;
    	}
    }
    
    private List<String> pathList(String path) {
    	List<String> result = new ArrayList<>();
    	if (path.length() == 1) return result;
    	int last = 0;
    	for (int i = 1; i < path.length(); i++) {
    		if (path.charAt(i) == '/') {
    			result.add(path.substring(last + 1, i));
    			last = i;
    		}
    	}
    	result.add(path.substring(last + 1));
    	return result;
    }
    
    public static void main(String[] args) {
    	Prob588 prob = new Prob588();
    	System.out.println(prob.ls("/"));
    	prob.mkdir("/a/b/c");
    	prob.addContentToFile("/a/b/c/d","hello");
    	System.out.println(prob.ls("/"));
    	System.out.println(prob.readContentFromFile("/a/b/c/d"));
    }
}
