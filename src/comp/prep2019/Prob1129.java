package comp.prep2019;
import java.util.*;
public class Prob1129 {
	// red 0, blue 1
	public int[] shortestAlternatingPaths(int n, int[][] red_edges, 
			int[][] blue_edges) {
        int[] result = new int[n];
        for (int i = 1; i < n; i++) result[i] = -1;
        Map<String, List<Integer>> map = new HashMap<>();
        populteEdgeMap(red_edges, 1, map);
        populteEdgeMap(blue_edges, 0, map);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        q.offer(new int[] {0, 1});
        int len = 0;
        int computed = 1;
        Set<String> visited = new HashSet<>();
        visited.add(0 + ":" + 0);
        visited.add(0 + ":" + 1);
        while(!q.isEmpty() && computed < n) {
        	len++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		String key = cur[0] + ":" + cur[1];
        		List<Integer> list = map.get(key);
        		if (list == null) continue;
        		for (int next : list) {
        			String nextKey = next + ":" + (cur[1] ^ 1);
        			if (visited.contains(nextKey)) continue;
        			if (result[next] == -1) {
	        			result[next] = len;
	        			computed++;
        			}
        			q.offer(new int[] {next, cur[1] ^ 1});
        			visited.add(nextKey);
        		}
        	}
        }
        return result;
    }
	
	private void populteEdgeMap(int[][] coloredEdges, int startingColor, 
			Map<String, List<Integer>> map) {
		for (int[] edge : coloredEdges) {
        	String key = edge[0] + ":" + startingColor;
        	List<Integer> list = map.getOrDefault(key, new ArrayList<>());
        	list.add(edge[1]);
        	map.put(key, list);
        }
	}
	
	public static void main(String[] args) {
		Prob1129 prob = new Prob1129();
		int[] result = prob.shortestAlternatingPaths(3, new int[][] {{0,1},{1,2}},
						new int[][] {});
		for (int i = 0; i < result.length; i++) System.out.print(result[i] + ", ");
	}
}
