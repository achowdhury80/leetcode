package com.prep2020.medium;
import java.util.*;
public class Problem990 {
	public boolean equationsPossible(String[] equations) {
		Map<Character, Character> parents = new HashMap<>();
        for (String eq : equations) {
        	if (eq.charAt(1) == '!') continue;
        	char c1, c2;
        	if (!parents.containsKey((c1 = eq.charAt(0)))) 
        			parents.put(c1, c1);
        	if (!parents.containsKey((c2 = eq.charAt(3)))) 
    			parents.put(c2, c2);
        	char p1 = findParent(c1, parents), 
        			p2 = findParent(c2, parents);
        	if (p1 != p2) parents.put((char)Math.max(p1, p2), 
        			(char)Math.min(p1, p2));
        }
        for (String eq : equations) {
        	if (eq.charAt(1) == '=') continue;
        	if (eq.charAt(0) == eq.charAt(3)) return false;
        	if (!parents.containsKey(eq.charAt(0)) 
        			|| !parents.containsKey(eq.charAt(3))) continue;
        	if (findParent(eq.charAt(0), parents) 
        			== findParent(eq.charAt(3), parents)) return false;
        }
        return true; 
    }
	
	private Character findParent(Character c, 
			Map<Character, Character> parents) {
		while(c != parents.get(c)) c = parents.get(c);
		return c;
	}
}
