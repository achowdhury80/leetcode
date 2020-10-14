package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob257 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		helper(root, "", result);
        return result;
    }
	
	private void helper(TreeNode node, String path, List<String> result) {
		if(node == null) return;
		path = path + node.val + "->";
		if (node.left == null && node.right == null) {
			result.add(path.substring(0, path.length() - 2));
			return;
		}
		helper(node.left, path, result);
		helper(node.right, path, result);
	}
}
