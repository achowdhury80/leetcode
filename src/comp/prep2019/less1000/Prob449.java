package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob449 {
	public String serialize(TreeNode root) {
		if (root == null) return "";
        StringBuilder result = new StringBuilder();
        result.append("," + root.val);
        result.append(serialize(root.left));
        result.append(serialize(root.right));
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if ("".equals(data)) return null;
        String[] arr = data.substring(1).split(",");
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        dq.addLast(root);
        for (int i = 1; i < arr.length; i++) {
        	int val = Integer.valueOf(arr[i]);
        	TreeNode node = new TreeNode(val);
        	TreeNode parent = null;
        	while(!dq.isEmpty() && dq.peekLast().val < val) {
        		parent = dq.pollLast();
        	}
        	if (parent == null) {
        		dq.peekLast().left = node;
        		dq.addLast(node);
        	} else {
        		parent.right = node;
        		dq.addLast(node);
        	}
        }
        return root;
    }
    
     public static void main(String[] args) {
    	Prob449 prob = new Prob449();
    	/*TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(2);*/
    	
    	TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
    	
    	String data = prob.serialize(root);
    	System.out.println(data);
    	TreeNode node = prob.deserialize(data);
    	System.out.println(node);
    }
}
