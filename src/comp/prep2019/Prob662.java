package comp.prep2019;
import java.util.*;
public class Prob662 {
	 public int widthOfBinaryTree(TreeNode root) {
		    if(root == null) return 0;
		    List<TreeNode> list = new ArrayList<>();
		    list.add(root);
		    int result = 0;
		    Map<TreeNode, Integer> map = new HashMap<>();
		    map.put(root, 0);
		    while (!list.isEmpty()){
		      List<TreeNode> temp = new ArrayList<>();
		      for(TreeNode node : list){
		        if(node.left != null) {
		          temp.add(node.left);
		          map.put(node.left, 2 * map.get(node) + 1);
		        }
		        if(node.right != null) {
		          temp.add(node.right);
		          map.put(node.right, 2 * map.get(node) + 2);
		        }
		      }
		      result = Math.max(result, map.get(list.get(list.size() - 1)) - map.get(list.get(0)) + 1);
		      list = temp;
		    }
		    return result;
		  }
}
