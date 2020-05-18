package comp.prep2019;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob865 {
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
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
}
