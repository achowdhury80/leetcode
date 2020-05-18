package comp.prep2019;

public class Prob1061 {
	public String smallestEquivalentString(String A, String B, String S) {
        char[] parent = new char[26];
        for (int i = 0; i < 26; i++) parent[i] = (char) (i + 'a');
        for (int i = 0; i < A.length(); i++) {
        	char c1 = A.charAt(i), c2 = B.charAt(i);
        	char p1 = findParent(parent, c1);
        	char p2 = findParent(parent, c2);
        	if (p1 < p2) parent[p2 - 'a'] = p1;
        	else if (p1 > p2) parent[p1 - 'a'] = p2;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) sb.append(findParent(parent, c));
        return sb.toString();
    }
	
	private char findParent(char[] arr, char c) {
		while(arr[c - 'a'] != c) c = arr[c - 'a'];
		return c;
	}
}
