package comp.prep2019;

public class Prob988 {
	public String smallestFromLeaf(TreeNode root) {
        String[] result = new String[] {""};
        dfs(root, "", result);
        return result[0];
    }
	
	private void dfs(TreeNode root, String path, String[] result) {
		path = (char)(root.val + 'a') + path;
		if(root.left == null && root.right == null) {
			if ("".equals(result[0]) || path.compareTo(result[0]) < 0) 
				result[0] = path;
		}
		if (root.left != null) dfs(root.left, path, result);
		if (root.right != null) dfs(root.right, path, result);
		
		
	}
	
	public static void main(String[] args) {
		Prob988 prob = new Prob988();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		System.out.println(prob.smallestFromLeaf(root));
	}
}
