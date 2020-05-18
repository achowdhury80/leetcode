package comp.prep2019;
import java.util.*;
public class Prob662 {
	public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int result = 1;
        while(!q.isEmpty()) {
        	int size = q.size();
        	List<TreeNode> list = new ArrayList<>();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		if (node == null) {
        			list.add(null);
        			list.add(null);
        		} else {
	        		list.add(node.left);
	        		list.add(node.right);
        		}
        	}
        	while(!list.isEmpty() && list.get(0) == null) list.remove(0);
        	while(!list.isEmpty() && list.get(list.size() - 1) == null) list.remove(list.size() - 1);
        	result = Math.max(result, list.size());
        	q.addAll(list);
        }
        return result;
    }
}
