package comp.prep2019;
import java.util.*;
public class Prob652 {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		lookupId(root, new HashMap<>(), new HashMap<>(), new int[]{1}, result);
		return result;
    }
	
	private int lookupId(TreeNode root, Map<String, Integer> trees, 
			Map<Integer, Integer> counts, int[] t, List<TreeNode> result) {
		if (root == null) return 0;
		String serial = root.val + "," + lookupId(root.left, trees, counts, t, result) 
			+ "," + lookupId(root.right, trees, counts, t, result);
		//int uid = trees.computeIfAbsent(serial, x-> t[0]++);
		int uid = -1;
		if(trees.containsKey(serial)) uid = trees.get(serial);
		else {
			uid = t[0];
			trees.put(serial, t[0]);
			t[0]++;
		}
		counts.put(uid, counts.getOrDefault(uid, 0) + 1);
        if (counts.get(uid) == 2)
            result.add(root);
        return uid;
	}
}
