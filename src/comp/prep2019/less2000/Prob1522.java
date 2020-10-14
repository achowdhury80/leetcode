package comp.prep2019.less2000;
import java.util.*;

public class Prob1522 {
	public int diameter(Node root) {
        int[] result = new int[] {0};
        helper(root, result);
        return result[0];
    }
	
	private int helper(Node root, int[] result) {
		if (root == null) return -1;
		if (root.children == null || root.children.isEmpty()) return 0;
		Queue<Integer> q = new PriorityQueue<>((x, y) -> x - y);
		for (Node child : root.children) {
			int pathLen = helper(child, result);
			q.offer(pathLen);
			if (q.size() > 2) q.poll();
		}
		if (q.size() == 2) result[0] = Math.max(result[0], 2 + q.poll() + q.peek());
		else if (q.size() == 1) result[0] = Math.max(result[0], 1 + q.peek()); 
		return 1 + q.poll();
	}
	
	static class Node {
	    public int val;
	    public List<Node> children;

	    
	    public Node() {
	        children = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        children = new ArrayList<Node>();
	    }
	    
	    public Node(int _val,ArrayList<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
}
