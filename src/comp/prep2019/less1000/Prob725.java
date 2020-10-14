package comp.prep2019.less1000;

import comp.prep2019.ListNode;

public class Prob725 {
	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] result = new ListNode[k];
		if (root == null) return result;
		int n = findLength(root);
		
		// create list of sizes
		int remainder = n % k;
		int partSize = n / k;
		int[] sizes = new int[k];
		for (int i = 0; i < k; i++) {
			sizes[i] = partSize;
			if (remainder > 0) {
				sizes[i]++;
				remainder--;
			}
		}
		ListNode cur = root;
		//populate eash listNode
		for (int i = 0; i < k; i++) {
			ListNode dummy = new ListNode(-1);
			ListNode temp = dummy;
			for (int j = 0; j < sizes[i]; j++) {
				temp.next = cur;
				cur = cur.next;
				temp = temp.next;
				temp.next = null;
			}
			result[i] = dummy.next;
		}
		return result;
    }
	
	/**
	 * find length of the list
	 * @param root
	 * @return
	 */
	private int findLength(ListNode root) {
		int result = 0;
		ListNode cur = root;
		while(cur != null) {
			result++;
			cur = cur.next;
		}
		return result;
	}
}
