package com.prep2020.medium;
import java.util.*;
public class Problem1600 {
	private Node king;
	private Map<String, Node> nameNodeMap;
	public Problem1600(String kingName) {
        king = new Node(kingName);
        nameNodeMap = new HashMap<>();
        nameNodeMap.put(kingName, king);
    }
    
    public void birth(String parentName, String childName) {
        Node parent = nameNodeMap.get(parentName);
        if (parent.children == null) parent.children = new ArrayList<>();
        Node child = new Node(childName);
        parent.children.add(child);
        nameNodeMap.put(childName, child);
    }
    
    public void death(String name) {
    	nameNodeMap.get(name).dead = true;
    }
    
    public List<String> getInheritanceOrder() {
    	List<String> result = new ArrayList<>();
    	findInheritanceOrder(king, result);
    	return result;
    }
    
    private void findInheritanceOrder(Node root, List<String> result) {
    	if (!root.dead) result.add(root.name);
    	if (root.children != null) for (Node child : root.children) findInheritanceOrder(child, result);
    }
    
    class Node {
    	String name;
    	boolean dead;
    	List<Node> children;
    	Node(String name) {
    		this.name = name;
    	}
    }
}
