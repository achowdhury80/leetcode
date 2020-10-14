package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob237 {
	public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
