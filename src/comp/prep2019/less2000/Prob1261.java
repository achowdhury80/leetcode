package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob1261 {
	private Set<Integer> set;
	public Prob1261(TreeNode root) {
        set = new HashSet<>();
        populate(root, 0, set);
    }
	
	private void populate(TreeNode root, int val, Set<Integer> set) {
		if (root == null) return;
		set.add(val);
		populate(root.left, 2 * val + 1, set);
		populate(root.right, 2 * val + 2, set);
	}
    
    public boolean find(int target) {
        return set.contains(target);
    }
}
