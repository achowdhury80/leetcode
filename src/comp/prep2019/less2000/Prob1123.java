package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob1123 {
	public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<TreeNode> prev = null, list = new ArrayList<>();
        list.add(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	prev = list;
        	list = new ArrayList<>();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		if (node.left != null) list.add(node.left);
        		if (node.right != null) list.add(node.right);
        	}
        	q.addAll(list);
        	
        }
        if (prev.size() == 1) return prev.get(0);
        return lowestCommonAncestor(root, prev.get(0), prev.get(prev.size() - 1));
    }
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) return null;
        if (root == p || root == q) return  root;
        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);
        if (leftAncestor != null && rightAncestor != null) return root;
        return leftAncestor== null ? rightAncestor : leftAncestor;
	}
	
	public static void main(String[] args) {
		Prob1123 prob = new Prob1123();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		TreeNode result = prob.lcaDeepestLeaves(root);
		System.out.println(result);
	}
}
