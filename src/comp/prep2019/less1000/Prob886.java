package comp.prep2019.less1000;
import java.util.*;
public class Prob886 {
	public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length < 2) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes) {
        	List<Integer> l1 = map.getOrDefault(dislike[0], new ArrayList<>());
        	List<Integer> l2 = map.getOrDefault(dislike[1], new ArrayList<>());
        	l1.add(dislike[1]);
        	l2.add(dislike[0]);
        	map.put(dislike[0], l1);
        	map.put(dislike[1], l2);
        }
        boolean[] visited = new boolean[N + 1];
        Set<Integer>[] set = new Set[2];
        set[0] = new HashSet<>(); 
        set[1] = new HashSet<>();
        for (int i = 1; i <= N; i++) {
        	if (visited[i]) continue;
        	set[0].add(i);
        	Queue<int[]> q = new LinkedList<>();
        	q.offer(new int[] {i, 0});
        	while(!q.isEmpty()) {
        		int[] cur = q.poll(); 
	        	for (int j : map.getOrDefault(cur[0], new ArrayList<>())) {
	        		if (set[cur[1]].contains(j)) return false;
	        		if (visited[j]) continue;
	        		int g =(cur[1] + 1) % 2; 
	        		set[g].add(j);
	        		q.offer(new int[] {j, g});
	        		visited[j] = true;
	        	}
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		Prob886 prob = new Prob886();
		System.out.println(prob.possibleBipartition(3, new int[][] {{1, 2}, 
			{1, 3}, {2, 3}}));
	}
}
