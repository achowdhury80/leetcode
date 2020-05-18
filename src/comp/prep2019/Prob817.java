package comp.prep2019;

public class Prob817 {
	/**
	 * use a boolean array to quickly find element exists in G
	 * run through the input linked list
	 * check if the val in boolean array
	 * if yes, if last element was connected then do nothing
	 * else increment result and set last connected to true
	 * if not in array set last connected to false
	 * @param head
	 * @param G
	 * @return
	 */
	public int numComponents(ListNode head, int[] G) {
        boolean[] arr = new boolean[10001];
        for (int i : G) arr[i] = true;
        int result = 0;
        ListNode cur = head;
        boolean lastConnected = false;
        while(cur != null) {
        	if (arr[cur.val]) {
        		if (!lastConnected) {
        			lastConnected = true;
        			result++;
        		}
        	} else {
        		lastConnected = false;
        	}
        	cur = cur.next;
        }
        return result;
    }
}
