package comp.prep2019.less1000;
public class Prob116 {
	public Node connect(Node root) {
       if (root == null) return null;
       Node dummy = new Node();
       dummy.next = root;
       while(dummy.next != null) {
    	   Node temp = new Node();
    	   Node curTemp = temp, cur = dummy.next;
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
    	   dummy = temp;
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
