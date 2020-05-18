package comp.prep2019;

public class Prob449 {
	public String serialize(TreeNode root) {
        String result = "";
        if (root == null) return result;
        result += root.val;
        if (root.left != null) {
        	result += "(" + serialize(root.left) + ")";
        }
        if (root.right != null) {
        	if (root.left == null) {
        		result += "()";
        	}
        	result += "(" + serialize(root.right) + ")";
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        if (data.indexOf("(") < 0) {
        	TreeNode root = new TreeNode(Integer.valueOf(data));
        	return root;
        }
        int leftParenIndex = -1;
        TreeNode root = new TreeNode(Integer.valueOf(data.substring(0, (leftParenIndex = data.indexOf("(")))));
        int rightParenIndex = findClosingBracketIndex(data, leftParenIndex);
        String leftData = data.substring(leftParenIndex + 1, rightParenIndex);
        System.out.println(leftData);
        root.left =  deserialize(leftData);
        if (data.length() > rightParenIndex + 1) {
	        data = data.substring(rightParenIndex + 1);
	        if (data.length() > 0) root.right = deserialize(data.substring(1, data.length() - 1));
        }
        return root;
    }
    
    private int findClosingBracketIndex(String data, int start) {
    	char[] arr = data.toCharArray();
    	int count = 1;
    	int i = start + 1;
    	while(i < data.length()) {
    		if (arr[i] == '(') count++;
    		else if (arr[i] == ')') {
    			count--;
    			if (count == 0) return i;
    		}
    		i++;
    	}
    	return -1;
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
