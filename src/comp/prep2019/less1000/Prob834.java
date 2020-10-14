package comp.prep2019.less1000;
import java.util.*;
public class Prob834 {
	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		if (N < 2) return new int[N];
		// lets consider 0 as root
        int[] depths = new int[N], parent = new int[N];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
        	List<Integer> list1 = map.getOrDefault(edge[0], new ArrayList<>()), list2 = map.getOrDefault(edge[1], new ArrayList<>());
        	list1.add(edge[1]);
        	list2.add(edge[0]);
        	map.put(edge[0], list1);
        	map.put(edge[1], list2);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[N];
        visited[0] = true;
        parent[0] = -1;
        depths[0] = 0;
        int depth = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	depth++;
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		List<Integer> list = map.get(cur);
        		for (int node : list) {
        			if (visited[node]) continue;
        			parent[node] = cur;
        			depths[node] = depth;
        			visited[node] = true;
        			q.offer(node);
        		}
        	}
        }
        
        int[] result = new int[N];
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < N; i++) {
        	int sum = 0;
        	for (int j = 0; j < N; j++) {
        		sum += findDistance(i, j, parent, depths, cache);
        	}
        	result[i] = sum;
        }
        return result;
    }

	private int findDistance(int i, int j, int[] parent, int[] depths, Map<Integer, Integer> cache) {
		if (i == j) return 0;
		int key = 0;
		if (i < j) {
			key = j;
			key |= (i << 14);
		} else {
			key = i;
			key |= (j << 14);
		}
		if (cache.containsKey(key)) return cache.get(key);
		int lower = i, higher = j;
		if (depths[i] < depths[j]) {
			lower = j;
			higher = i;
		}
		int result = 0;
		if (depths[lower] > depths[higher]) {
			result++;
			result += findDistance(parent[lower], higher, parent, depths, cache);
		}
		else if (lower != higher) {
			result += 2;
			result += findDistance(parent[lower], parent[higher], parent, depths, cache);
		}
		cache.put(key, result);
		return result;
	}
	
	public static void main(String[] args) {
		Prob834 prob = new Prob834();
		//System.out.println(prob.minCostII(new int[][] {{1, 5, 3},{2, 9, 4}}));
		int[] arr = prob.sumOfDistancesInTree(6, new int[][] {{0,1},{0,2},{2,3},{2,4},{2,5}});
		System.out.println(arr);
	}
}
