package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob255 {
  public boolean verifyPreorder(int[] preorder) {
    if (preorder == null || preorder.length < 1) return true;
    Integer lastFinished = null;
    int lastValidIndex = 0;
    for (int i = 1; i < preorder.length; i++) {
      if (preorder[i] < preorder[lastValidIndex]) {
        if (lastFinished != null && preorder[i] < lastFinished) return false;
        preorder[++lastValidIndex] = preorder[i];
      }
      else {
        int j = lastValidIndex;
        while (j > -1 && preorder[j] < preorder[i]) {
          lastFinished = preorder[j];
          j--;
        }
        lastValidIndex = j;
        preorder[++lastValidIndex] = preorder[i];

      }
    }
    return true;
  }

//  public boolean verifyPreorder(int[] preorder) {
//    if (preorder == null || preorder.length < 1) return true;
//    Stack<Integer> stack = new Stack<>();
//    stack.push(preorder[0]);
//    Integer lastFinished = null;
//    for (int i = 1; i < preorder.length; i++) {
//      if (preorder[i] < stack.peek()) {
//        if (lastFinished != null && preorder[i] < lastFinished) return false;
//        stack.push(preorder[i]);
//      }
//      else {
//        while (!stack.empty() && stack.peek() < preorder[i]) {
//          lastFinished = stack.pop();
//        }
//        stack.push(preorder[i]);
//      }
//    }
//    return true;
//  }



  public static void main(String[] args) {
    Prob255 prob255 = new Prob255();
    System.out.println(prob255.verifyPreorder(new int[]{1, 2}));
  }
}
