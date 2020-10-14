package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob1457 {
	/**
	 * o(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int pseudoPalindromicPaths (TreeNode root) {
        int[] result = new int[] {0};
        helper(root, new HashSet<>(), result);
        return result[0];
    }
	
	private void helper(TreeNode root, Set<Integer> set, int[] result) {
		if (root == null) return;
		if (!set.contains(root.val)) set.add(root.val);
		else set.remove(root.val);
		if (root.left == null && root.right == null) {
			if (set.size() < 2) {
				result[0]++;
			}
			return;
		}
		helper(root.left, new HashSet<>(set), result);
		helper(root.right, new HashSet<>(set), result);
	}
}
