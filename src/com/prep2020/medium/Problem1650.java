package com.prep2020.medium;
import java.util.*;
public class Problem1650 {
	/**
	 * O(h1 + h2) time and space
	 * @param p
	 * @param q
	 * @return
	 */
	public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        while(p != null) {
        	set.add(p);
        	p = p.parent;
        }
        while(!set.contains(q)) q = q.parent;
        return q;
    }
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node parent;
	}
}
