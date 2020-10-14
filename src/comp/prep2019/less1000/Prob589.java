package comp.prep2019.less1000;
import java.util.*;
public class Prob589 {
	public List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			result.add(cur.val);
			if (cur.children != null) {
				for (int i = cur.children.size() - 1; i > -1; i--) 
					stack.push(cur.children.get(i));
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
