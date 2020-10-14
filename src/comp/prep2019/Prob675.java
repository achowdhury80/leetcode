package comp.prep2019;
import java.util.*;
public class Prob675 {
    public int cutOffTree(List<List<Integer>> forest) {
    	Queue<int[]> q = new PriorityQueue<>((x, y) -> forest.get(x[0]).get(x[1]) 
        		- forest.get(y[0]).get(y[1])) ;
        for (int i = 0; i < forest.size(); i++) {
        	for (int j = 0; j < forest.get(i).size(); j++) {
        		if (forest.get(i).get(j) > 1) q.offer(new int[] {i, j});
        	}
        }
        int[] cur = new int[] {0, 0};
        int result = 0;
        while(!q.isEmpty()) {
        	int[] temp;
        	int dist = findDistance(forest, cur, (temp = q.poll()));
        	if (dist == -1) return -1;
        	result += dist;
        	cur = temp;
        }
        return result;
    }

	public int findDistance(List<List<Integer>> forest, int[] cur,  int[] dest) {
		if (cur[0] == dest[0] && cur[1] == dest[1]) return 0;
		Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cur[0], cur[1]});
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[cur[0]][cur[1]] = true;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;
        while (!q.isEmpty()) {
        	int size = q.size();
        	result++;
        	for (int i = 0; i < size; i++) {
	        	cur = q.poll();
	            for (int[] dir : dirs) {
	            	int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
	            	if (next[0] < 0 || next[0] == forest.size() || next[1] < 0 
							|| next[1] == forest.get(0).size() 
							|| visited[next[0]][next[1]] 
							|| forest.get(next[0]).get(next[1]) == 0) continue;
	                if (next[0] == dest[0] && next[1] == dest[1]) return result;
	                visited[next[0]][next[1]] = true;
	                q.offer(next);
	            }
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Prob675 prob = new Prob675();
		System.out.println(prob.cutOffTree(Arrays.asList(Arrays.asList(1, 2, 3), 
				Arrays.asList(0, 0, 4), 
				Arrays.asList(7, 6, 5))));
	}
}
