package comp.prep2019;

public class Prob430 {
	public Node flatten(Node head) {
		if (head == null) return head;
		return helper(head)[0];
    }
	
	private Node[] helper(Node node) {
		Node[] result = new Node[] {node, node};
		Node next = node.next;
		if (node.child != null) {
			Node[] childFlattern = helper(node.child);
			node.child = null;
			result[1].next = childFlattern[0];
			childFlattern[0].prev = result[1];
			result[1] = childFlattern[1];
		}
		if (next != null) {
			Node[] nextFlatterned = helper(next);
			result[1].next = nextFlatterned[0];
			nextFlatterned[0].prev = result[1];
			result[1] = nextFlatterned[1];
		}
		return result;
	}
	
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	}
}
