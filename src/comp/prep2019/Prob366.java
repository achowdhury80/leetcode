package comp.prep2019;
import java.util.*;
public class Prob366 {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		findDepth(root, result);
		return result;
    }
	
	private int findDepth(TreeNode root, List<List<Integer>> result) {
		if (root == null) return -1;
		int depth = 1 + Math.max(findDepth(root.left, result), 
				findDepth(root.right, result));
		if (result.size() < depth + 1) result.add(new ArrayList<>());
		result.get(depth).add(root.val);
		return depth;
	}
}
