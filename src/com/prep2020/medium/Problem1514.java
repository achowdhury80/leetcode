package com.prep2020.medium;
import java.util.*;
public class Problem1514 {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Queue<Pair> pq = new PriorityQueue<>((x, y) -> (x.probability < y.probability ? 1 : -1));
		Map<Integer, Double>[] nexts = new Map[n];
		double[] dist = new double[n];
		for (int i = 0; i < n; i++) {
			nexts[i] = new HashMap<>();
			dist[i] = 0;
		}
		
		for (int i = 0; i < edges.length; i++) {
			nexts[edges[i][0]].put(edges[i][1], succProb[i]);
			nexts[edges[i][1]].put(edges[i][0], succProb[i]);
		}
		
		pq.offer(new Pair(start, 1));
		while(!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (dist[pair.node] < pair.probability) {
				dist[pair.node] = pair.probability;
				if (pair.node == end) return pair.probability;
				for (Map.Entry<Integer, Double> entry : nexts[pair.node].entrySet()) {
					pq.offer(new Pair(entry.getKey(), entry.getValue() * pair.probability));
				}
			}
		}
		return 0;
    }
	
	class Pair {
		int node;
		double probability;
		Pair(int node, double probability) {
			this.node = node;
			this.probability = probability;
		}
	}
	
	public static void main(String[] args) {
		Problem1514 problem = new Problem1514();
		System.out.println(problem.maxProbability(3, new int[][] {{0, 1}, {1, 2}, {0, 2}}, new double[] {0.5, .5, .2}, 0, 2));
	}
}
