package comp.prep2019;

public class Prob536 {
	public TreeNode str2tree(String s) {
        if (s == null || s.equals("")) return null;
        int indexOfStartBracket = s.indexOf("(");
        if (indexOfStartBracket < 0) return new TreeNode(Integer.valueOf(s));
        TreeNode root = new TreeNode(Integer.valueOf(s.substring(0, indexOfStartBracket)));
        int count = 0;
        int indexOfLeftEnd = -1;
        for (int i = indexOfStartBracket; i < s.length(); i++) {
        	if (s.charAt(i) == '(') count++;
        	if (s.charAt(i) == ')') count--;
        	if (count == 0) {
        		indexOfLeftEnd = i;
        		break;
        	}
        }
        root.left = str2tree(s.substring(indexOfStartBracket + 1, indexOfLeftEnd));
        if (indexOfLeftEnd != s.length() - 1) {
        	root.right = str2tree(s.substring(indexOfLeftEnd + 2, s.length() - 1));
        }
        return root;
    }
	
	public static void main(String[] args) {
		Prob536 prob = new Prob536();
		TreeNode node = prob.str2tree("4(2(3)(1))(6(5))");
		System.out.println(node);
	}
}
