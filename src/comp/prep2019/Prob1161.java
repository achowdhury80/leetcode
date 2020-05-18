package comp.prep2019;
import java.util.*;
public class Prob1161 {
	public int maxLevelSum(TreeNode root) {
       if (root == null) return 0;
       Queue<TreeNode> q = new LinkedList<>();
       int[] pair = new int[] {0, Integer.MIN_VALUE};
       q.offer(root);
       int level = 0;
       while(!q.isEmpty()) {
    	   int size = q.size();
    	   level++;
    	   int sum = 0;
    	   for (int i = 0; i < size; i++) {
    		   TreeNode node = q.poll();
    		   sum += node.val;
    		   if (node.left != null) q.offer(node.left);
    		   if(node.right != null) q.offer(node.right);
    	   }
    	   if (sum > pair[1]) {
    		   pair[0] = level;
    		   pair[1] = sum;
    	   }
       }
       return pair[0];
    }
	
	public static void main(String[] args) {
		Prob1161 prob = new Prob1161();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(0);
		TreeNode seven = new TreeNode(7);
		seven.left = new TreeNode(7);
		seven.right = new TreeNode(-8);
		root.left = seven;
		System.out.println(prob.maxLevelSum(root));
	}
}
