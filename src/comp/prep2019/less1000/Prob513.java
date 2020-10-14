package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob513 {
	public int findBottomLeftValue(TreeNode root) {
        TreeNode result = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		if (node.left != null) q.offer(node.left);
        		if(node.right != null) q.offer(node.right);
        		if(i == 0) result = node;
        	}
        }
        return result.val;
    }
}
