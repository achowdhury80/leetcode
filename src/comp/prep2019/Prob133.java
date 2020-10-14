package comp.prep2019;
import java.util.*;
public class Prob133 {
	private Map<Node, Node> map = new HashMap<>();
	public Node cloneGraph(Node node) {
		if (node == null) return null;
		if (map.containsKey(node)) return map.get(node);
		Node clonned = new Node(node.val, null);
		map.put(node, clonned);
		if (node.neighbors != null) {
			clonned.neighbors = new ArrayList<>();
			for (Node child : node.neighbors) {
				clonned.neighbors.add(cloneGraph(child));
			}
		}
		return clonned;
	}
	public Node cloneGraph1(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        map.put(node, new Node(node.val, null));
        // create the clones only but no connection
        while(!q.isEmpty()) {
        	Node n = q.poll();
        	if (n.neighbors != null) {
        		for (Node p : n.neighbors) {
        			if (!map.containsKey(p)) {
        				map.put(p, new Node(p.val, null));
        				q.offer(p);
        			}
        		}
        	}
        }
        Set<Node> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        // set the connections
        while(!q.isEmpty()) {
        	Node n = q.poll();
        	if (n.neighbors != null) {
        		List<Node> neighs = new ArrayList<>();
        		for (Node p : n.neighbors) {
        			neighs.add(map.get(p));
        			if (!visited.contains(p)) {
        				q.offer(p);
        				visited.add(p);
        			}
        		}
        		map.get(n).neighbors = neighs;
        	}
        }
        return map.get(node);
    }
	
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
}
