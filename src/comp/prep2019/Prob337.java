package comp.prep2019;
import java.util.*;
public class Prob337 {
	public int rob(TreeNode root) {
	    if(root == null) return 0;
	    int[] sums = robx(root);
	    return Math.max(sums[0], sums[1]);
	  }

	  private int[] robx(TreeNode root){
	    if(root == null) return new int[2];
	    int[] left = robx(root.left);
	    int[] right = robx(root.right);
	    return new int[]{root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
	  }
}
