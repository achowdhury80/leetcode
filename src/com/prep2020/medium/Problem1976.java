package com.prep2020.medium;
import java.util.*;
public class Problem1976 {
	int N = 1000000007;
    public int countPaths(int n, int[][] roads) {
        int ret = 0;
        Map<Integer, List<Edge>> adj = new HashMap<>();
        boolean[] visited = new boolean[n];
        boolean[] done = new boolean[n];
        int[] dist = new int[n];
        //build graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(new Edge(u, v, wt));
            adj.get(v).add(new Edge(v, u, wt));
        }
        PriorityQueue<DNode> pq = new PriorityQueue<>(new Comparator<DNode>() {
            @Override
            public int compare(DNode o1, DNode o2) {
                return o1.dist - o2.dist;
            }
        });
        pq.add(new DNode(0,0));
        visited[0] = true;
        dist[0] = 0;
        long[] numWays = new long[n];
        numWays[0] = 1;
        while (!pq.isEmpty()) {
            DNode node = pq.poll();
            if (done[node.v]) {
                continue;
            }
            if (adj.containsKey(node.v)) {
                for (Edge edge : adj.get(node.v)) {
                    int nbrV = edge.v;
                    if (!visited[nbrV]) {
                        pq.add(new DNode(nbrV, dist[node.v] + edge.weight));
                        visited[nbrV] = true;
                        dist[nbrV] = dist[node.v] + edge.weight;
                        numWays[nbrV] = numWays[node.v]%N;
                    } else {
                        if (dist[nbrV] > dist[node.v] + edge.weight) {
                            pq.add(new DNode(nbrV, dist[node.v] + edge.weight));
                            dist[nbrV] = dist[node.v] + edge.weight;
                            numWays[nbrV] = numWays[node.v];
                        } else if (dist[nbrV] == dist[node.v] + edge.weight) {
                            numWays[nbrV] = (numWays[nbrV] + numWays[node.v])%N;
                        }
                    }
                }
            }
            done[node.v] = true;
        }
        return (int)numWays[n-1];
    }

    class Edge {
        int u;
        int v;
        int weight;
        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        public String toString() {
            return "("+u+", "+v+", "+weight+")";
        }
    }
    class DNode {
        int v;
        int dist;
        public DNode(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
        public String toString() {
            return "DN("+v+", "+dist+")";
        }
    }
	
	public static void main(String[] args) {
		Problem1976 problem = new Problem1976();
		System.out.println(problem.countPaths(7, new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
	}
}
