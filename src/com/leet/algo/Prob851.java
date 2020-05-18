package com.leet.algo;
import java.util.*;
public class Prob851 {
	public int[] loudAndRich(int[][] richer, int[] quiet) {
		Node[] nodes = new Node[quiet.length];
		for (int[] rich : richer) {
			if (nodes[rich[1]] == null) nodes[rich[1]] = new Node(rich[1]);
			nodes[rich[1]].children.add(rich[0]);
		}
		int[] result = new int[quiet.length];
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] == null) result[i] = i;
			else {
				int min = i;
				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				Set<Integer> visited = new HashSet<>();
				visited.add(i);
				while(!q.isEmpty()) {
					int node = q.poll();
					if (quiet[min] > quiet[node]) min = node;
					if (nodes[node] == null) continue;
					for (int child : nodes[node].children) {
						if (!visited.contains(child)) {
							visited.add(child);
							q.offer(child);
						}
					}
				}
				result[i] = min;
			}
		}
		return result;
	}
	
	class Node {
		int label;
		List<Integer> children = new ArrayList<>();
		Node(int label) {
			this.label = label;
		}
	}
	
	public static void main(String[] args) {
		Prob851 prob = new Prob851();
		int[] ans = prob.loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}},
			new int[] {3,2,5,4,6,1,7,0});
		
		for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + ",");
	}
}
