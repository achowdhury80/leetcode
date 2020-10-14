package comp.prep2019.less2000;
import java.util.*;
public class Prob1339_old {
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int[] edge : edges) {
			List<int[]> list1 = map.getOrDefault(edge[0], new ArrayList<>());
			List<int[]> list2 = map.getOrDefault(edge[1], new ArrayList<>());
			list1.add(new int[] {edge[1], edge[2]});
			list2.add(new int[] {edge[0], edge[2]});
			map.put(edge[0], list1);
			map.put(edge[1], list2);
		}
		int cityCount = Integer.MAX_VALUE, result = -1;
		for (int i = 0; i < n; i++) {
			Queue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
			int count = 0;
			Set<Integer> set = new HashSet<>();
			for (int[] arr : map.getOrDefault(i, new ArrayList<>())) {
				count++;
				if (arr[1] <= distanceThreshold) {
					q.offer(new int[] {arr[0], arr[1]});
					set.add(arr[0]);
				}
			}
			set.add(i);
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				for (int[] next : map.getOrDefault(cur[0], new ArrayList<>())) {
					if (set.contains(next[0]) 
							|| (cur[1] + next[1]) > distanceThreshold) continue;
					count++;
					q.offer(new int[] {next[0], cur[1] + next[1]});
					set.add(next[0]);
				}
			}
			if(count <= cityCount) {
				cityCount = count;
				result = i;
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		Prob1339_old prob = new Prob1339_old();
		System.out.println(prob.findTheCity(4,
				new int[][] {{0,1,3},{1,2,1},{1,3,4},{2,3,1}},
						4));
	}
}
