package comp.prep2019;
import java.util.*;
public class Prob222 {
	public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.offer(root);
        int lastLevelSize = 0;
        while(!q.isEmpty()) {
        	depth++;
        	int size = q.size();
        	lastLevelSize = 0;
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		if (node.left != null) q.offer(node.left);
        		if (node.right != null) q.offer(node.right);
        		lastLevelSize++;
        	}
        }
        return (int)Math.pow(2, depth - 1) - 1 + lastLevelSize;
    }
}
