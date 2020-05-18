package comp.prep2019;

public class Prob510 {
	public Node inorderSuccessor(Node x) {
		if (x == null) return null;
		Node cur = null;
        if (x.right != null) {
        	cur = x.right;
        	while(cur.left != null) cur = cur.left;
        	return cur;
        }
        cur = x.parent; 
        while(cur != null) {
        	if (cur.left == x) return cur;
        	x = cur;
        	cur = cur.parent;
        }
        return null;
    }
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node parent;
	}
}
