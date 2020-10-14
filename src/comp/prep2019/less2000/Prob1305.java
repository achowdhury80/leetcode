package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob1305 {
	/**
	 * O(M + N) time and space O(H1 + H2) - worst case O(M + N)
	 * @param root1
	 * @param root2
	 * @return
	 */
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		Queue<InOrderItr> q = new PriorityQueue<>((x, y) -> x.peek() - y.peek());
		if (root1 != null) q.offer(new InOrderItr(root1));
		if (root2 != null) q.offer(new InOrderItr(root2));
		List<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			InOrderItr itr = q.poll();
			result.add(itr.next());
			if (itr.hasNext()) q.offer(itr);
		}
		return result;
    }
	
	class InOrderItr implements Iterator<Integer>{
		private Stack<TreeNode> stack;
		InOrderItr(TreeNode root) {
			stack = new Stack<>();
			if(root == null) return;
			stack.push(root);
			TreeNode cur = root;
			while(cur.left != null) {
				cur = cur.left;
				stack.push(cur);
			}
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			TreeNode node = stack.pop();
			if(node.right != null) populate(node.right);
			return node.val;
		}
		
		public int peek() {
			return stack.peek().val;
		}
		
		private void populate(TreeNode node) {
			if(node == null) return;
			stack.push(node);
			while(node.left != null) {
				node = node.left;
				stack.push(node);
			}
		}
	}
}
