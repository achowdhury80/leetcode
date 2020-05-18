package comp.prep2019;
import java.util.*;
public class Prob1361 {
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] isRoot = new boolean[n];
        for (int i = 0; i < n; i++) isRoot[i] = true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	List<Integer> list;
        	int left, right;
        	if ((left = leftChild[i]) != -1) {
        		list = map.getOrDefault(i, new ArrayList<>());
        		list.add(left);
        		map.put(i, list);
        		if (!isRoot[left]) return false;
        		isRoot[left] = false;
        	}
        	if ((right = rightChild[i]) != -1) {
        		list = map.getOrDefault(i, new ArrayList<>());
        		list.add(right);
        		map.put(i, list);
        		if (!isRoot[right]) return false;
        		isRoot[right] = false;
        	}
        }
        int root = -1;
    	for (int i = 0; i < n; i++) {
    		if (isRoot[i]) {
    			if (root > -1) return false;
    			else root = i;
    		}
    	}
    	if (root == -1) return false;
    	Queue<Integer> q = new LinkedList<>();
    	boolean[] visited = new boolean[n];
    	q.offer(root);
    	visited[root] = true;
    	int count = 1;
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		if (map.containsKey(cur)) {
    			for (int next : map.get(cur)) {
    				if (visited[next]) return false;
    				visited[next] = true;
    				count++;
    				q.offer(next);
    			}
    		}
    	}
    	return count == n;
    }
	
	public static void main(String[] args) {
		Prob1361 prob = new Prob1361();
		System.out.println(prob.validateBinaryTreeNodes(4, 
				new int[] {1, 2, 0, -1}, new int[] {-1, -1, -1, -1}));
	}
}
