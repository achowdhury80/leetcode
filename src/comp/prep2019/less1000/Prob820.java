package comp.prep2019.less1000;

public class Prob820 {
	public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        int result = 0;
        for (String w : words) {
        	Trie cur = root;
        	char[] arr = w.toCharArray();
        	boolean added = false;
        	for (int i = arr.length - 1; i > -1; i--) {
        		if (cur.child[arr[i] - 'a'] == null) {
        			cur.child[arr[i] - 'a'] = new Trie();
        			added = true;
        		}
        		cur = cur.child[arr[i] - 'a'];
        		if (cur.isWord && i != 0) {
        			result -= arr.length - i + 1;
        			cur.isWord = false;
        		}
        	}
        	if (added) {
        		result += arr.length + 1;
        		cur.isWord = true;
        	}
        }
        return result;
    }
	
	class Trie {
		Trie[] child = new Trie[26];
		boolean isWord;
	}
	public static void main(String[] args) {
		Prob820 prob = new Prob820();
		System.out.println(prob.minimumLengthEncoding(new String[] {"time", "atime", "btime"}));
	}
}
