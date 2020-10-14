package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob606 {
	public String tree2str(TreeNode t) {
		if (t == null) return "";
        String result = "" + t.val;
        if (t.left != null) result += "(" + tree2str(t.left) + ")";
        if (t.right != null) {
        	if (t.left == null) result += "()";
        	result += "(" + tree2str(t.right) + ")";
        }
        return result;
    }
}
