package comp.prep2019.less1000;
import java.util.*;
public class Prob559 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 1;
        if (root.children != null) {
        	for (Node node : root.children) {
        		depth = Math.max(depth, 1 + maxDepth(node));
        	}
        }
        return depth;
    }
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
}
