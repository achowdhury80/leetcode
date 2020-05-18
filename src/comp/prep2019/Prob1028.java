package comp.prep2019;

public class Prob1028 {
	public TreeNode recoverFromPreorder(String S) {
        if (S== null || "".equals(S)) return null;
        return helper(S, 0);
    }
	
	private TreeNode helper(String s, int dash) {
		// remove initial dashes
		s = s.substring(dash);
		//compute the node val
		int val = 0;
		char c;
		int i = 0;
		while (i < s.length() && (c = s.charAt(i)) != '-') {
			val = val * 10 + c - '0';
			i++;
		}
		TreeNode result = new TreeNode(val);
		// i == s.length then no left or right subtree
		if(i < s.length()) {
			// now s, contains left and potential right subtree
			s = s.substring(i);
			// find the starting index of right subtree
			int rightIndex = findLastIndexOf(s, dash + 1);
			//if no right subtree
			if (rightIndex == 0) {
				result.left = helper(s, dash + 1);
			} else { // there is a subtree
				result.left = helper(s.substring(0, rightIndex), dash + 1);
				result.right = helper(s.substring(rightIndex), dash + 1);
			}
		}
		return result;
	}
	
	/**
	 * Return starting index of last dash count of dashes
	 * @param s
	 * @param dash
	 * @return
	 */
	private int findLastIndexOf(String s, int dash) {
		int result = -1, count = 0;
		for (int i = s.length() -1; i > -1; i--) {
			if (s.charAt(i) == '-') count++;
			else {
				if (count == dash) return i + 1;
				count = 0;
			}
		}
		return count == dash ? 0 : result;
	} 
	
	public static void main(String[] args) {
		Prob1028 prob = new Prob1028();
		System.out.println(prob.recoverFromPreorder("1-2--3---4-5--6---7"));
	}
}
