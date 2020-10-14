package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob1302 {
	public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	sum = 0;
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		sum += node.val;
        		if(node.left != null) q.offer(node.left);
        		if(node.right != null) q.offer(node.right);
        	}
        }
        return sum;
    }
}
