package com.leet.algo;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob536 {

  public TreeNode str2tree(String s) {
    if (s == null || s.length() < 1) return null;
    int first = s.indexOf("(");
    if (first == -1) return new TreeNode(Integer.parseInt(s));
    TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, first)));
    int leftParenCount = 0;
    boolean leftComputed = false;
    for (int i = first; i < s.length(); i++) {
      if (s.charAt(i) == '(') leftParenCount++;
      if (s.charAt(i) == ')') leftParenCount--;
      if (leftParenCount == 0 && !leftComputed) {
        leftComputed = true;
        root.left = str2tree(s.substring(first + 1, i));
        first = i + 1;
      }
      else if (leftComputed && leftParenCount == 0) {
        root.right = str2tree(s.substring(first + 1, i));
      }
    }
    return root;
  }

//  public TreeNode str2tree(String s) {
//    if (s == null || s.length() < 1) return null;
//    return findRoot(s, new int[]{0});
//  }

  private TreeNode findRoot(String s, int[] postion) {
    if (postion[0] >= s.length()) return null;
    int start = postion[0];
    while (postion[0] < s.length() && (Character.isDigit(s.charAt(postion[0])) || s.charAt(postion[0]) == '-')) {
      postion[0]++;
    }

    TreeNode root = new TreeNode(Integer.parseInt(s.substring(start, postion[0])));
    if (postion[0] < s.length() && s.charAt(postion[0]) == '(') {
      postion[0]++;
      root.left = findRoot(s, postion);
      postion[0]++;
      if (postion[0] < s.length() && s.charAt(postion[0]) == '(') {
        postion[0]++;
        root.right = findRoot(s, postion);
        postion[0]++;
      }
    }
    return root;
  }

  public static void main(String[] args) {
    Prob536 prob536 = new Prob536();
    TreeNode root = prob536.str2tree("4(2(3)(1))(6(5))");
    System.out.println(root);
  }

}
