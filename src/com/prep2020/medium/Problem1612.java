package com.prep2020.medium;

public class Problem1612 {
	class Node {
		      char val;
		      Node left;
		      Node right;
		      Node() {this.val = ' ';}
		      Node(char val) { this.val = val; }
		      Node(char val, Node left, Node right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	/**
	 * O(m + N)
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean checkEquivalence(Node root1, Node root2) {
        int[] freq1 = new int[26], freq2 = new int[26];
        findFreq(root1, freq1); 
        findFreq(root2, freq2);
        for (int i = 0; i < 26; i++) {
        	if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }
	private void findFreq(Node root, int[] freq) {
		if (root == null) return;
		if (root.val != '+') freq[root.val - 'a']++;
		findFreq(root.left, freq);
		findFreq(root.right, freq);
	}
}
