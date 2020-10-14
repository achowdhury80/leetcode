package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		pathSum(root, sum, result, new ArrayList<>());
        return result;
    }
	
	private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        sum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
        	if (sum == 0) result.add(new ArrayList<>(path));
        	path.remove(path.size() - 1);
        	return;
        }
        if (root.left != null) pathSum(root.left, sum, result, path);
        if(root.right != null) pathSum(root.right, sum, result, path);
        path.remove(path.size() - 1);
    }
}
