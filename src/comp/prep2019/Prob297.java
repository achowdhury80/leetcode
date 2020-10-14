package comp.prep2019;
import java.util.*;
public class Prob297 {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if (root == null) return "";
        String result = "(";
        result += root.val;
        if (root.left != null) result += serialize(root.left);
        else if (root.right != null) result += "()";
        if (root.right != null) result += serialize(root.right);
        result += ")";
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < data.length(); i++) {
        	if (data.charAt(i) == '(') stack .push(i);
        	else if (data.charAt(i) == ')') {
        		int idx = stack.pop();
        		map.put(idx, i);
        	}
        }
        return helper(data, 0, data.length() - 1, map);
    }
    
    private TreeNode helper(String data, int start, int end, Map<Integer, 
    		Integer> map) {
    	if (start + 1 == end) return null;
    	int leftIndex = data.indexOf("(", start + 1);
    	if (leftIndex == -1 || leftIndex > end) {
    		return new TreeNode(Integer.parseInt(data.substring(start + 1, end)));
    	}
    	TreeNode result = new TreeNode(Integer.parseInt(data.substring(start + 1, 
    			leftIndex)));
    	int leftEnd = map.get(leftIndex);
    	result.left = helper(data, leftIndex, leftEnd, map);
    	if (leftEnd < end - 1) result.right = helper(data, leftEnd + 1, end - 1, map);
    	return result;
    }
}
