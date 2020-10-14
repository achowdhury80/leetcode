package comp.prep2019.less1000;
import java.util.*;
public class Prob590 {
	/**
	 * O(N) time and space - worst when the tree is skewed
	 * @param root
	 * @return
	 */
	public List<Integer> postorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	Node cur = stack.peek();
        	if (set.contains(cur)) {
        		result.add(cur.val);
        		stack.pop();
        	}
        	else {
        		List<Node> children = cur.children;
        		set.add(cur);
        		if(children != null) {
        			for (int i = children.size() - 1; i > -1; i--) {
        				stack.push(children.get(i));
        			}
        		}
        	}
        }
        return result;
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
