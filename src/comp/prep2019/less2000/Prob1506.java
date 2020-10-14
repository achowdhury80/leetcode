package comp.prep2019.less2000;
import java.util.*;
public class Prob1506 {
	public Node findRoot(List<Node> tree) {
        long sum = 0, childSum = 0;
        for (Node node : tree) {
        	sum += node.val;
        	if (node.children != null) {
        		for (Node child : node.children) {
        			childSum += child.val;
        		}
        	}
        }
        long rootVal = sum - childSum;
        for (Node node : tree) if (rootVal == node.val) return node;
        return null;
    }
	
	private static class Node {
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
