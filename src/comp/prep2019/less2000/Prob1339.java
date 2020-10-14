package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob1339 {
	public int maxProduct(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		findSum(root, map);
		int sum = map.get(root);
		int[] closestButSmallerThanHalf = new int[] {sum};
		findCeilValue(root, sum / 2, closestButSmallerThanHalf, map);
		return (int)((closestButSmallerThanHalf[0] * (sum + 0l - closestButSmallerThanHalf[0])) % (1e9 + 7));
    }
	
	private int findSum(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) return 0;
		int left = findSum(root.left, map);
		int right = findSum(root.right, map);
		int sum = left + root.val + right;
		map.put(root, sum);
		return sum;
	}
	
	private void findCeilValue(TreeNode root, int mid, int[] closest, Map<TreeNode, Integer> map) {
		if(root == null) return;
		int sum = map.get(root);
		if (sum == mid) {
			closest[0] = mid;
		} else {
			if (Math.abs(mid - closest[0]) > Math.abs(mid - sum)) {
				closest[0] = sum;
			}
			if (sum > mid) {
				findCeilValue(root.left, mid, closest, map);
				findCeilValue(root.right, mid, closest, map);
			}
		}
	}
	
	public static void main(String[] args) {
		Prob1339 prob = new Prob1339();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		System.out.println(prob.maxProduct(root));
		
	}
}
