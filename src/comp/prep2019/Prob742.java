package comp.prep2019;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class Prob742 {
	public int findClosestLeaf(TreeNode root, int k) {
	    Map<TreeNode, TreeNode> backMap = new HashMap<>();
	    TreeNode target = dfs(root, k, backMap);
	    Queue<TreeNode> q = new LinkedList<>();
	    Set<TreeNode> visited = new HashSet<>();
	    visited.add(target);
	    q.add(target);
	    while (!q.isEmpty()) {
	      TreeNode node = q.poll();
	      if (node.left == null && node.right == null) return node.val;
	      if (node.left != null && visited.add(node.left)) q.offer(node.left);
	      if (node.right != null && visited.add(node.right)) q.offer(node.right);
	      if (backMap.containsKey(node) && visited.add(backMap.get(node))) q.offer(backMap.get(node));
	    }
	    return -1;
	  }

	  private TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
	    if (root.val == k) return root;
	    if (root.left != null) {
	      backMap.put(root.left, root);
	      TreeNode left = dfs(root.left, k, backMap);
	      if (left != null) return left;
	    }
	    if (root.right != null) {
	      backMap.put(root.right, root);
	      TreeNode right = dfs(root.right, k, backMap);
	      if (right != null) return right;
	    }
	    return null;
	  }
	
	public static void main(String[] args) {
		Prob742 prob = new Prob742();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(6);
		root.right.left.left.left = new TreeNode(8);
		root.right.left.left.right = new TreeNode(9);
		root.right.right.right = new TreeNode(7);
		root.right.right.right.left = new TreeNode(10);
		int result = prob.findClosestLeaf(root, 7);
		System.out.println(result);
	}
}
