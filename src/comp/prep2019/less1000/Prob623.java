package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob623 {
	public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
        	TreeNode node = new TreeNode(v);
        	node.left = root;
        	return node;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(d > 2) {
        	d--;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode cur = q.poll();
        		if (cur.left != null) q.offer(cur.left);
        		if(cur.right != null) q.offer(cur.right);
        	}
        }
        while(!q.isEmpty()) {
        	TreeNode cur = q.poll();
        	TreeNode left = new TreeNode(v);
        	TreeNode right = new TreeNode(v);
        	left.left = cur.left;
        	right.right = cur.right;
        	cur.left = left;
        	cur.right = right;
        }
        return root;
    }
}
