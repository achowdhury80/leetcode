package comp.prep2019.less1000;
import java.util.*;
public class Prob310 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        Map<Integer, List<Integer>> nexts = new HashMap<>();
        int[] indeg = new int[n];
        for (int[] edge : edges) {
            indeg[edge[0]]++;
            indeg[edge[1]]++;
            List<Integer> l1 = nexts.getOrDefault(edge[0], new ArrayList<>());
            l1.add(edge[1]);
            nexts.put(edge[0], l1);
            List<Integer> l2 = nexts.getOrDefault(edge[1], new ArrayList<>());
            l2.add(edge[0]);
            nexts.put(edge[1], l2);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 1) q.offer(i);
        while(!q.isEmpty()) {
            if (nexts.size() < 3) {
                for (int key : nexts.keySet()) result.add(key);
	    		break;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
	            int node = q.poll();
	            for (int next : nexts.get(node)) {
	                indeg[next]--;
	                if (indeg[next] == 1) q.offer(next);
	            }
	            nexts.remove(node);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob310 prob = new Prob310();
		System.out.println(prob.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}}));
	}
}
