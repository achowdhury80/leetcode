package comp.prep2019;
import java.util.*;
public class Prob863 {
	/**
	 * O(N) time space
	 * @param root
	 * @param target
	 * @param K
	 * @return
	 */
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		Map<TreeNode, TreeNode> backMap = new HashMap<>();
		findTarget(root, target, backMap);
		List<Integer> result = new ArrayList<>();
		if (K == 0) {
			result.add(target.val);
			return result;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(target);
		Set<Integer> set = new HashSet<>();
		set.add(target.val);
		while(K > 0) {
			K--;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null && !set.contains(node.left.val)) {
					q.offer(node.left);
					set.add(node.left.val);
				}
				if (node.right != null && !set.contains(node.right.val)) {
					q.offer(node.right);
					set.add(node.right.val);
				}
				if (backMap.containsKey(node) && !set.contains(backMap.get(node).val)) {
					q.offer(backMap.get(node));
					set.add(backMap.get(node).val);
				}
			}
		}
		while(!q.isEmpty()) result.add(q.poll().val);
		return result;
    }
	
	private boolean findTarget(TreeNode root, TreeNode target, Map<TreeNode, TreeNode> backMap) {
		if (root == null) return false;
		if (root == target) return true;
		if (root.left != null) {
			backMap.put(root.left, root);
			if (findTarget(root.left, target, backMap)) return true;
		}
		
		if (root.right != null) {
			backMap.put(root.right, root);
			if (findTarget(root.right, target, backMap)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Prob863 prob = new Prob863();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		List<Integer> result = prob.distanceK(root, root.left.right, 1);
		System.out.println(result);
	}
}
