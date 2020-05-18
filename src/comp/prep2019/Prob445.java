package comp.prep2019;
import java.util.*;
public class Prob445 {
	/**
	 * since reversing is not allowed, we will use stack
	 * populate two stack with two list node(order msd at the bottom)
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        populateStack(l1, s1);
        populateStack(l2, s2);
        ListNode result = null;
        int carry = 0;
        while(!s1.isEmpty() && !s2.isEmpty()) {
        	int sum = s1.pop() + s2.pop() + carry;
        	ListNode l = new ListNode(sum % 10);
        	l.next = result;
        	result = l;
        	carry = sum / 10;
        }
        Stack<Integer> s = s1.isEmpty() ? s2 : s1;
        while(!s.isEmpty()) {
        	int sum = s.pop() + carry;
        	ListNode l = new ListNode(sum % 10);
        	l.next = result;
        	result = l;
        	carry = sum / 10;
        }
        if (carry > 0) {
        	ListNode l = new ListNode(carry);
        	l.next = result;
        	result = l;
        }
        return result;
    }
	
	/**
	 * populate stack - Most significant digit at the bottom
	 * @param l
	 * @param s
	 */
	private void populateStack(ListNode l, Stack<Integer> s) {
		while(l != null) {
			s.push(l.val);
			l = l.next;
		}
	}
}
