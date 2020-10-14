package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob993 {
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root.val == x || root.val == y) return false;
        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[] {root, null});
        boolean[] found = new boolean[2];
        TreeNode[] parent = new TreeNode[2];
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode[] cur = q.poll();
        		if (cur[0].val == x) {
        			found[0] = true;
        			parent[0] = cur[1];
        		} else if (cur[0].val == y) {
        			found[1] = true;
        			parent[1] = cur[1];
        		} else {
        			if (cur[0].left != null) 
        				q.offer(new TreeNode[] {cur[0].left, cur[0]});
        			if (cur[0].right != null) 
        				q.offer(new TreeNode[] {cur[0].right, cur[0]});
        		}
        	}
        	if (found[0] || found[1]) {
        		if (parent[0] != null && parent[1] != null && parent[0] != parent[1])
        			return true;
        		else return false;
        	}
        }
        return false;
    }
}
