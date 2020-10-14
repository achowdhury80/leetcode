package comp.prep2019;
import java.util.*;
public class Prob1514 {
	/**
	 * O(NlogN + E)
	 * @param n
	 * @param edges
	 * @param succProb
	 * @param start
	 * @param end
	 * @return
	 */
	public double maxProbability(int n, int[][] edges, double[] succProb, 
			int start, int end) {
        List<double[]>[] nexts = new List[n];
        for (int i = 0; i < edges.length; i++) {
        	if (nexts[edges[i][0]] == null) nexts[edges[i][0]] = new ArrayList<>();
        	nexts[edges[i][0]].add(new double[] {edges[i][1], succProb[i]});
        	if (nexts[edges[i][1]] == null) nexts[edges[i][1]] = new ArrayList<>();
        	nexts[edges[i][1]].add(new double[] {edges[i][0], succProb[i]});
        }
        Queue<double[]> q = new PriorityQueue<>((x, y) -> x[1] > y[1] ? -1 : 1);
        q.offer(new double[] {start, 1});
        boolean[] visited = new boolean[n];
        while(!q.isEmpty()) {
        	double[] cur = q.poll();
        	if (cur[0] == end) return cur[1];
        	int node = (int)cur[0];
        	visited[node] = true;
        	if (nexts[node] != null) {
        		for (double[] next : nexts[node]) {
        			if (visited[(int)next[0]]) continue;
        			double[] nextNode = new double[] {next[0], cur[1] * next[1]};
        			q.offer(nextNode);
        		}
        	}
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Prob1514 prob = new Prob1514();
		System.out.println(prob.maxProbability(3, new int[][] {{0,1},{1,2},{0,2}}, 
				new double[] {.5, .5, .2}, 0, 2));
	}
}
