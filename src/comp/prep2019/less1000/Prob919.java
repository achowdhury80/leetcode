package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob919 {
	private TreeNode root;
	private Queue<TreeNode> q;
	public Prob919(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	if(q.peek().right == null) {
        		if (q.peek().left != null) q.offer(q.peek().left);
        		break;
        	}
        	TreeNode node = q.poll();
        	q.offer(node.left);
        	q.offer(node.right);
        }
    }
    
    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode peek = q.peek();
        if (peek.left == null) {
        	peek.left = node;
        	q.offer(node);
        	return peek.val;
        } else {
        	peek.right = node;
        	q.offer(node);
        	q.poll();
        	return peek.val;
        }
    }
    
    public TreeNode get_root() {
        return root;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	Prob919 prob = new Prob919(root);
    	System.out.println(prob.insert(5));
    	System.out.println(prob.insert(6));
    	System.out.println(prob.insert(7));
    	System.out.println(prob.insert(8));
    	TreeNode node = prob.get_root();
    	System.out.println(node);
    	
    }
}
