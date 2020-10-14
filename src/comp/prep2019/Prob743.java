package comp.prep2019;
import java.util.*;
public class Prob743 {
	/**
	 * O(N + E) time and O(N) space
	 * @param times
	 * @param N
	 * @param K
	 * @return
	 */
	public int networkDelayTime(int[][] times, int N, int K) {
		boolean[] visited = new boolean[N + 1];
		int count = 0;
        List<int[]>[] nexts = new List[N + 1];
        for (int i = 1; i <= N; i++) nexts[i] = new ArrayList<>();
        for (int[] time : times) {
        	nexts[time[0]].add(new int[] {time[1], time[2]});
        }
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        q.offer(new int[] {K, 0});
        int result = Integer.MIN_VALUE;
        while(!q.isEmpty() && count < N) {
        	int[] cur = q.poll();
        	if (visited[cur[0]]) continue;
        	visited[cur[0]] = true;
        	result = Math.max(result, cur[1]);
        	count++;
        	for (int[] next : nexts[cur[0]]) {
        		if (visited[next[0]]) continue;
        		q.offer(new int[] {next[0], cur[1] + next[1]});
        	}
        }
        return count < N ? -1 : result;
    }
	
	public static void main(String[] args) {
		Prob743 prob = new Prob743();
		System.out.println(prob.networkDelayTime(new int[][] {{2,1,1}, {2,3,1},{3, 4, 1}}, 4, 2));
	}
}
