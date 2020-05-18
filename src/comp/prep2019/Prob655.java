package comp.prep2019;
import java.util.*;
public class Prob655 {
	public List<List<String>> printTree(TreeNode root) {
		int height = findHeight(root);
		List<List<String>> result = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			List<String> list = new ArrayList<>();
			for (int j = 0; j < Math.pow(2, height) - 1; j++) {
				list.add("");
			}
			result.add(list);
		}
		populate(root, result, 0, 0, (int)Math.pow(2, height) - 1);
		return result;
    }
	
	private int findHeight(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		return 1 + Math.max(findHeight(root.left), findHeight(root.right));
	}
	
	private void populate(TreeNode root, List<List<String>> result, int level, int leftboundaryIndex, int rightBoundaryIndex) {
		List<String> list = result.get(level);
		int pos = (leftboundaryIndex + rightBoundaryIndex) / 2;
		list.set(pos, "" + root.val);
		if (root.left != null) populate(root.left, result, level + 1, leftboundaryIndex, pos - 1);
		if (root.right != null) populate(root.right, result, level + 1, pos + 1, rightBoundaryIndex);
	}
}
