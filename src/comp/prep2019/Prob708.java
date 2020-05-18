package comp.prep2019;

public class Prob708 {
	/**
	 * The idea is that there are only three cases we should insert the node in the while loop:
1. insertVal is in in between previous node and next node
2. next.val < prev.val (i.e. we are at the turning point) and insertVal > prev.val
3. next.val < prev.val and insertVal < next.val

if not inserted in the while loop, we simply add it before head.
	 * @param head
	 * @param insertVal
	 * @return
	 */
	public Node insert(Node head, int insertVal) {
	Node newNode = new Node(insertVal, null);
    if (head == null) {
        return newNode;
    }
    Node prev = head;
    Node next = head.next;
    while (next != head) {
        if (insertVal >= prev.val && insertVal <= next.val || 
           (next.val < prev.val && insertVal < next.val) ||
           (next.val < prev.val && insertVal > prev.val)) {
            //insert between prev and next
            prev.next = newNode;
            newNode.next = next;
            break;
        }
        prev = next;
        next = next.next;
    }
    
    //insert at the beginning
    if (next == head) { 
        prev.next = newNode;
        newNode.next = next;
    }
    return head;
	}
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
