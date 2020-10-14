package comp.prep2019.less1000;
import java.util.*;
public class Prob936 {
	public int[] movesToStamp(String stamp, String target) {
        Stack<Integer> stack = new Stack<>();
        int m = stamp.length(), n = target.length();
        List<Node> list = new ArrayList<>();
        boolean[] done = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <= n - m; i++) {
        	Set<Integer> made = new HashSet<>(), todo = new HashSet<>();
        	for (int j = 0; j < m; j++) {
        		if (target.charAt(i + j) == stamp.charAt(j)) made.add(i + j);
        		else todo.add(i + j);
        	}
        	list.add(new Node(made, todo));
        	if (todo.isEmpty()) {
        		stack.push(i);
        		for (int j = i; j < i + m; j++) {
        			done[j] = true;
        			q.offer(j);
        		}
        	}
        }
        while(!q.isEmpty()) {
        	int i = q.poll();
        	for (int j = Math.max(0, i - m + 1); j <= Math.min(n - m, i); j++) {
        		if (list.get(j).todo.contains(i)) {
        			list.get(j).todo.remove(i);
        			if (list.get(j).todo.isEmpty()) {
        				stack.push(j);
        				for (int k : list.get(j).made) {
        					q.offer(k);
        					done[k] = true;
        				}
        			}
        		}
        	}
        }
        
        for (boolean b : done) {
        	if (!b) return new int[0];
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) result[i] = stack.pop();
        return result;
    }
	class Node {
		Set<Integer> made, todo;
		Node(Set<Integer> m, Set<Integer> t) {
	        made = m;
	        todo = t;
	    }
	}
	
	public static void main(String[] args) {
		Prob936 prob = new Prob936();
		int[] result = prob.movesToStamp("abca", "aabcaca");
		for (int i : result) System.out.print(i + ", ");
	}
}
