package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob987 {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0] != y[0]) ? 
				(x[0] - y[0]) : ((x[1] != y[1]) ? (x[1] - y[1]) : (x[2] - y[2])));
		populate(root, new int[] {0, 0}, pq);
		int listIndex = 1001;
		while(!pq.isEmpty()) {
			int[] arr = pq.poll();
			if (arr[0] != listIndex) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[2]);
				result.add(list);
			} else {
				List<Integer> list = result.get(result.size() - 1);
				list.add(arr[2]);
			}
			listIndex = arr[0];
		}
		return result;
    }
	
	private void populate(TreeNode root, int[] pos, Queue<int[]> pq) {
		pq.offer(new int[] {pos[0], pos[1], root.val});
		if (root.left != null) 
			populate(root.left, new int[] {pos[0] - 1, pos[1] + 1}, pq);
		if (root.right != null) 
			populate(root.right, new int[] {pos[0] + 1, pos[1] + 1}, pq);
	}
	
	public static void main(String[] args) {
		Prob987 prob = new Prob987();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> result = prob.verticalTraversal(root);
		System.out.println(result);
	}
}
