package comp.prep2019.less1000;
import java.util.*;
public class Prob428 {
	// Encodes a tree to a single string.
    public String serialize(Node root) {
    	List<String> list = new ArrayList<>();
    	serHelper(root, list);
        return String.join(",", list);
    }
    
    private void serHelper(Node node, List<String> list) {
    	if (node == null) return;
    	list.add("" + node.val);
    	list.add("" + node.children.size());
    	for (Node child : node.children) serHelper(child, list);
    }
    
    

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>();
        for (String ss : data.split(",")) q.offer(ss);
        return deSerHelper(q);
    }
    
    private Node deSerHelper(Queue<String> q) {
    	Node root = new Node(Integer.parseInt(q.poll()));
        int size = Integer.parseInt(q.poll());
        root.children = new ArrayList<>();
        for (int i = 0; i < size; i++) root.children.add(deSerHelper(q));
        return root;
    }
    
    public static void main(String[] args) {
    	Prob428 prob = new Prob428();
    	Node root = new Node(1);
    	Node three = new Node(3);
    	three.children = new ArrayList<>();
    	three.children.add(new Node(5));
    	three.children.add(new Node(6));
    	root.children = new ArrayList<>();
    	root.children.add(three);
    	root.children.add(new Node(2));
    	root.children.add(new Node(4));
    	String data = prob.serialize(root);
    	System.out.println(data);
    	Node newRoot = prob.deserialize(data);
    	System.out.println(newRoot);
    }
    
    static class Node {
    	public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
    }
    
}

