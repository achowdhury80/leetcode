package comp.prep2019;
import java.util.*;


public class Prob314 {
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> fwdResult = new ArrayList<>();
		List<List<Integer>> bkwdResult = new ArrayList<>();
		helper(root, 0, fwdResult, bkwdResult);
		for (List<Integer> list : bkwdResult) fwdResult.add(0, list);
		return fwdResult;
	}
	
	private void helper(TreeNode root, int curCol, List<List<Integer>> fwdResult, 
			List<List<Integer>> bkwdResult) {
		if (root == null) return;
		if (curCol >= 0) {
			List<Integer> list = null;
			if (fwdResult.size() == curCol) {
				list = new ArrayList<>();
				fwdResult.add(list);
			}
			list = fwdResult.get(curCol);
			list.add(root.val);
		} else {
			List<Integer> list = null;
			int idx = -curCol - 1;
			if (bkwdResult.size() == idx) {
				list = new ArrayList<>();
				bkwdResult.add(list);
			}
			list = bkwdResult.get(idx);
			list.add(root.val);
		}
		helper(root.left, curCol - 1, fwdResult, bkwdResult);
		helper(root.right, curCol + 1, fwdResult, bkwdResult);
	}
	public List<List<Integer>> verticalOrder1(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<>();
	    if (root == null) return result;
	    TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
	    Queue<Object[]> q = new LinkedList<>();
	    q.add(new Object[]{root, 0});
	    while (!q.isEmpty()) {
	      Object[] objArr = q.poll();
	      TreeNode node = (TreeNode) objArr[0];
	      int degree = (Integer) objArr[1];
	      if (!treeMap.containsKey(objArr[1])) treeMap.put(degree, new ArrayList<>());
	      treeMap.get(degree).add(node.val);
	      if (node.left != null) q.offer(new Object[]{node.left, degree - 1});
	      if (node.right != null) q.offer(new Object[]{node.right, degree + 1});
	    }
	    for (int key : treeMap.keySet()) {
	      result.add(treeMap.get(key));
	    }
	    return result;
	  }
	
	public static void main(String[] args) {
		Prob314 prob = new Prob314();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.right = new TreeNode(11);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(prob.verticalOrder(root));
	}
}
