package com.leet.algo;
import java.util.*;
public class Prob987 {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] != y[0] ? x[0] - y[0] 
			: (x[1] != y[1] ? y[1] - x[1] : x[2] - y[2]));
		populate(root, new int[] {0, 0}, pq);
		int lineIndex = -1001;
		while(!pq.isEmpty()) {
			int[] arr = pq.poll();
			if (arr[0] == lineIndex) {
				result.get(result.size() - 1).add(arr[2]);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(arr[2]);
				result.add(list);
				lineIndex = arr[0];
			}
		}
		return result;
    }
	
	private void populate(TreeNode root, int[] pos, PriorityQueue<int[]> pq) {
		pq.offer(new int[] {pos[0], pos[1], root.val});
		if (root.left != null) {
			populate(root.left, new int[] {pos[0] - 1, pos[1] - 1}, pq);
		}
		if (root.right != null) {
			populate(root.right, new int[] {pos[0] + 1, pos[1] - 1}, pq);
		}
	}
}
