package comp.prep2019;
import java.util.*;
public class Prob1171 {
	public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> sumToFarthestNodeMap = new HashMap<>();
        int sum = 0;
        ListNode cur = head;
        ListNode result = new ListNode(-1);
        result.next = head;
        // create a map of sum to the farthest node with that sum starting from oth index
        while(cur != null) {
        	sum += cur.val;
        	// if sum is zero, remove all the nodes till that node
        	if (sum == 0) {
        		result.next = cur.next;
        		sumToFarthestNodeMap.clear();
        	} else {
        		sumToFarthestNodeMap.put(sum, cur);
        	}
        	cur = cur.next;
        }
        
        sum = 0;
        cur = result.next;
        while(cur != null) {
        	sum += cur.val;
        	if (sumToFarthestNodeMap.get(sum) != cur) {
        		cur.next = sumToFarthestNodeMap.get(sum).next;
        	}
        	cur = cur.next;
        }
        return result.next;
    }
	
	public static void main(String[] args) {
		Prob1171 prob = new Prob1171();
		ListNode head = new ListNode(1), cur = head;
		cur.next = new ListNode(2);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(-3);
		cur = cur.next;
		cur.next = new ListNode(4);
		ListNode result = prob.removeZeroSumSublists(head);
		while(result != null) {
			System.out.print(result.val + ", ");
			result = result.next;
		}
		
	}
}
