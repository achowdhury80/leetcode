package comp.prep2019;
import java.util.*;
public class Prob111 {
	public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int result = 1;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		if (node.left == null && node.right == null) return result;
        		if (node.left != null) q.offer(node.left);
        		if (node.right != null) q.offer(node.right);
        	}
        	result++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob111 prob = new Prob111();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(prob.minDepth(root));
	}
}
