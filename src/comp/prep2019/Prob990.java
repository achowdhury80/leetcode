package comp.prep2019;
import java.util.*;
public class Prob990 {
	public boolean equationsPossible(String[] equations) {
		char[] parents = new char[26];
		for (int i = 0; i < 26; i++) parents[i] = (char)(i + 'a');
		List<Integer> notEqIndices = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
        	String eq = equations[i];
        	if (eq.charAt(1) == '!') notEqIndices.add(i);
        	else {
        		char p1 = findParent(parents, eq.charAt(0));
        		char p2 = findParent(parents, eq.charAt(3));
        		if (p1 != p2) {
        			if (p1 < p2) {
        				parents[p2 - 'a'] = p1;
        			} else parents[p1 - 'a'] = p2;
        		}
        	}
        }
        for (int i : notEqIndices) {
        	String eq = equations[i];
        	char p1 = findParent(parents, eq.charAt(0));
    		char p2 = findParent(parents, eq.charAt(3));
    		if (p1 == p2) return false;
        }
        return true;
    }
	
	private char findParent(char[] parents, char c) {
		while(parents[c - 'a'] != c) c = parents[c - 'a'];
		return c;
	}
}
