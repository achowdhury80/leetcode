package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.ListNode;
public class Prob1019 {
	/**
	 * O(N) time and spce
	 * reverse the list
	 * maintain a stack of bigger numbers
	 * @param head
	 * @return
	 */
	public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        int[] count = new int[] {0};
        ListNode reversed = reverse(head, count);
        int[] result = new int[count[0]];
        ListNode cur = reversed;
        Stack<Integer> stack = new Stack<>();
        stack.push(cur.val);
        for (int i = count[0] - 2; i > -1; i--) {
        	cur = cur.next;
        	while(!stack.isEmpty() && stack.peek() <= cur.val) {
        		stack.pop();
        	}
        	if (!stack.isEmpty()) {
        		result[i] = stack.peek();
        	}
        	stack.push(cur.val);
        }
        return result;
    }
	
	private ListNode reverse(ListNode head, int[] count) {
		count[0]++;
		if (head == null || head.next == null) return head;
		ListNode reversed = reverse(head.next, count);
		head.next.next = head;
		head.next = null;
		return reversed;
	}
	
	public static void main(String[] artgs) {
		Prob1019 prob = new Prob1019();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(5);
		int[] arr = prob.nextLargerNodes(head);
		for (int i : arr) System.out.print(i + ",");
	}
}
