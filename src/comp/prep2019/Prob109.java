package comp.prep2019;
import java.util.*;
public class Prob109 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		ListNode cur = head;
		List<ListNode> list = new ArrayList<>();
        while(cur != null) {
        	list.add(cur);
        	cur = cur.next;
        }
        return helper(list, 0, list.size() - 1);
    }
	
	private TreeNode helper(List<ListNode> list, int start, int end) {
		if (start > end) return null;
		if (start == end) return new TreeNode(list.get(start).val);
		int mid = start + (end - start) / 2;
		TreeNode result = new TreeNode(list.get(mid).val);
		result.left = helper(list, start, mid - 1);
		result.right = helper(list, mid + 1, end);
		return result;
	}
}
