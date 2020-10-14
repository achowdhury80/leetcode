package comp.prep2019;
import java.util.*;
public class Prob1530 {
	public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        int[] result = new int[] {0};
        helper(root, distance, result);
        return result[0];
    }
	
	private Map<Integer, Integer> helper(TreeNode root, int distance, int[] result) {
		Map<Integer, Integer> retVal = new HashMap<>();
		if (root.left == null && root.right == null) {
			retVal.put(0, 1);
			return retVal;
		}
		Map<Integer, Integer> leftMap = null, rightMap = null;
		if (root.left != null) leftMap = helper(root.left, distance, result);
		if (root.right != null) rightMap = helper(root.right, distance, result);
		if (leftMap != null && rightMap != null) {
			for (Map.Entry<Integer, Integer> leftEntry : leftMap.entrySet()) {
				for (Map.Entry<Integer, Integer> rightEntry : rightMap.entrySet()) {
					if (leftEntry.getKey() + rightEntry.getKey() + 2 <= distance) {
						result[0] += leftEntry.getValue() * rightEntry.getValue();
					}
				}
			}
		}
		if (leftMap != null) {
			for (Map.Entry<Integer, Integer> leftEntry : leftMap.entrySet()) {
				if (1 + leftEntry.getKey() <= distance)
				retVal.put(1 + leftEntry.getKey(), leftEntry.getValue());
			}
		}
		if (rightMap != null) {
			for (Map.Entry<Integer, Integer> rightEntry : rightMap.entrySet()) {
				if (1 + rightEntry.getKey() <= distance)
				retVal.put(1 + rightEntry.getKey(), 
						retVal.getOrDefault(1 + rightEntry.getKey(), 0) 
						+ rightEntry.getValue());
			}
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		Prob1530 prob = new Prob1530();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		System.out.println(prob.countPairs(root, 3));
	}
}
