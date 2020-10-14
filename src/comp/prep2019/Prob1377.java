package comp.prep2019;
import java.util.*;
public class Prob1377 {
	public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
        	List<Integer> l0 = map.getOrDefault(edge[0], new ArrayList<>()),
        			l1 = map.getOrDefault(edge[1], new ArrayList<>());
        	l0.add(edge[1]);
        	l1.add(edge[0]);
        	map.put(edge[0], l0);
        	map.put(edge[1], l1);
        }
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, visited));
        for (int i = 0; i < t - 1 && !q.isEmpty(); i++) {
        	int size = q.size();
        	for (int j = 0; j < size; j++) {
        		Node node = q.poll();
        		List<Integer> l = map.get(node.cur);
        		List<Integer> nextMoves = new ArrayList<>();
        		if (l != null) {
        			for (int next : l) {
        				if (!node.visited[next]) nextMoves.add(next);
        			}
        		}
        		if (nextMoves.isEmpty()) {
        			if (node.cur == target) q.offer(node);
        		} else {
        			if (node.cur == target) continue;
        			for (int next : nextMoves) {
        				boolean[] newVisited 
        					= Arrays.copyOf(node.visited, node.visited.length);
        				newVisited[next] = true;
        				q.offer(new Node(next, newVisited, 
        						node.prob * (1.0 / nextMoves.size())));
        			}
        		}
        	}
        }
        if (q.isEmpty()) return 0;
        double result = 0;
        while(!q.isEmpty()) {
        	Node node = q.poll();
        	List<Integer> nextMoves = new ArrayList<>();
        	List<Integer> l = map.get(node.cur);
    		if (l != null) {
    			for (int next : l) {
    				if (!node.visited[next]) nextMoves.add(next);
    			}
    		}
    		if (nextMoves.isEmpty()) {
    			if (node.cur == target) result += node.prob;
    		} else {
    			int size = nextMoves.size();
    			if (nextMoves.contains(target)) {
    				result += node.prob * (1.0 / size);
    			}
    		}
        }
        return result;
    }
	
	class Node {
		int cur;
		boolean[] visited;
		double prob = 1;
		Node(int cur, boolean[] visited) {
			this.cur = cur;
			this.visited = visited;
		}
		
		Node(int cur, boolean[] visited, double prob) {
			this(cur, visited);
			this.prob = prob;
		}
		
	}
	
	public static void main(String[] args) {
		Prob1377 prob = new Prob1377();
		System.out.println(prob.frogPosition(7, new int[][] {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}}, 2, 4));
	}
}
