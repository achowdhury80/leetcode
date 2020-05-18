package comp.prep2019;
import java.util.*;
public class Prob1379 {
	public final TreeNode getTargetCopy(final TreeNode original, 
			final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(original);
        int level = 0, index = -1;
        boolean found = false;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode cur = q.poll();
        		if (cur == target) {
        			index = i;
        			found = true;
        			break;
        		} 
        		if (cur.left != null) q.offer(cur.left);
        		if (cur.right != null) q.offer(cur.right);
        	}
        	if (found) break;
        	level++;
        }
        if(level == 0) return cloned;
        q.clear();
        q.offer(cloned);
        int curLevel = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode cur = q.poll();
        		if (curLevel == level && i == index) {
        			return cur;
        		} 
        		if (cur.left != null) q.offer(cur.left);
        		if (cur.right != null) q.offer(cur.right);
        	}
        	curLevel++;
        }
        return null;
    }
}
