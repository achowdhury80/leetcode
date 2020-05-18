package comp.prep2019;
import java.util.*;
public class Prob663 {
	public boolean checkEqualTree(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = findSum(root, map);
		return sum % 2 == 0 && (sum == 0 ? map.get(0) > 1 : map.containsKey(sum / 2));
    }
	
	private int findSum(TreeNode root, Map<Integer, Integer> map) {
		if (root == null) return 0;
		int sum = root.val + findSum(root.left, map) + findSum(root.right, map);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		return sum;
	}
}
