package comp.prep2019.less1000;
import java.util.*;
public class Prob138 {
	/**
	 * two iterations
	 * in the first iteration create deep copy of each node and maintain a map of current node and new node
	 * in the second iteration, update random pointers
	 * @param head
	 * @return
	 */
	public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Node result = new Node(), rCur = result;
        Map<Node, Node> map = new HashMap<>();
        while(cur != null) {
        	rCur.next = new Node(cur.val, null, null);
        	map.put(cur, rCur.next);
        	rCur = rCur.next;
        	cur = cur.next;
        }
        cur = head;
        rCur = result.next;
        while(cur != null) {
        	rCur.random = map.get(cur.random);
        	cur = cur.next;
        	rCur = rCur.next;
        }
        return result.next;
    }
	
	class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	}
}
