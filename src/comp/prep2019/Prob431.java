package comp.prep2019;
import java.util.*;
public class Prob431 {
	// Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
    	if (root == null) return null;
    	TreeNode treeNode = new TreeNode(root.val);
    	if (root.children != null && root.children.size() > 0) {
    		TreeNode last = null;
    		for (int i = root.children.size() - 1; i > -1; i--) {
    			TreeNode child = encode(root.children.get(i));
    			child.right = last;
    			last = child;
    		}
    		treeNode.left = last;
    	}
    	return treeNode;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node node = new Node(root.val, new ArrayList<>());
        TreeNode childrenHead = root.left;
        if (childrenHead != null) {
        	while(childrenHead != null) {
        		node.children.add(decode(childrenHead));
        		childrenHead = childrenHead.right;
        	}
        }
        return node;
    }
    
    public static void main(String[] args) {
    	Prob431 prob = new Prob431();
    	Node root = new Node(1);
    	root.children = new ArrayList<>();
    	Node node = new Node(3);
    	node.children = new ArrayList<>();
    	node.children.add(new Node(5));
    	node.children.add(new Node(6));
    	root.children.add(node);
    	root.children.add(new Node(2));
    	root.children.add(new Node(4));
    	TreeNode treeNode = prob.encode(root);
    	Node nodeR = prob.decode(treeNode);
    	System.out.println(nodeR);
    }
    
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
