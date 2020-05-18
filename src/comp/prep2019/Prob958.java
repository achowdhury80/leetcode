package comp.prep2019;
import java.util.*;
public class Prob958 {
	public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isFull = true;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		if (node.left == null) {
        			isFull = false;
        		} 
        		else if (!isFull) return false;
        		else q.offer(node.left);
        		if(node.right == null) isFull = false;
        		else if(!isFull) return false;
        		else q.offer(node.right);
        	}
        }
        return true;
    }
}
