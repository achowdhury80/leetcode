package comp.prep2019;
import java.util.*;
public class Prob971 {
	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		List<Integer> result = new ArrayList<>();
		if (root.val != voyage[0]) {
			result.add(-1);
			return result;
		}
		Map<Integer, Integer> posMap = new HashMap<>();
		for (int i = 0; i < voyage.length; i++) {
			posMap.put(voyage[i], i);
		}
		if (!helper(root, voyage, 0, voyage.length - 1, posMap, result)) {
			result.clear();
			result.add(-1);
			return result;
		}
		return result;
    }
	
	private boolean helper(TreeNode root, int[] voyage, int start, int end, Map<Integer, Integer> posMap, List<Integer> result) {
		if (start >= end) return true;
		if (root.left == null && root.right == null) return true;
		if (root.left == null) return root.right.val == voyage[start + 1] && helper(root.right, voyage, start + 1, end, posMap, result);
		if (root.right == null) return root.left.val == voyage[start + 1] && helper(root.left, voyage, start + 1, end, posMap, result);
		int leftSubStart = posMap.getOrDefault(root.left.val, -1), rightSubStart = posMap.getOrDefault(root.right.val, -1);
		if (leftSubStart == -1 || rightSubStart == -1) return false;
		if (leftSubStart == start + 1) {
			return helper(root.left, voyage, leftSubStart, rightSubStart - 1, posMap, result)
					&& helper(root.right, voyage, rightSubStart, end, posMap, result);
		} else if (rightSubStart == start + 1) {
			result.add(root.val);
			return helper(root.right, voyage, rightSubStart, leftSubStart - 1, posMap, result)
					&& helper(root.left, voyage, leftSubStart, end, posMap, result);
		} else return false;
	}
}
