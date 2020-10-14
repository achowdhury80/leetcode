package comp.prep2019.less1000;

public class Prob117 {
	
	public Node connect(Node root) {
        Node start = new Node();
        start.next = root;
        while(start.next != null) {
        	Node cur = start.next;
        	start = new Node();
        	Node curTemp = start;
        	while(cur != null) {
        		if (cur.left != null) {
        			curTemp.next = cur.left;
        			curTemp = curTemp.next;
        		}
        		if (cur.right != null) {
        			curTemp.next = cur.right;
        			curTemp = curTemp.next;
        		}
        		cur = cur.next;
        	}
        }
        return root;
    }
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}

}
