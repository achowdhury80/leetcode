package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 11/10/17.
 */
public class Prob31 {
  public void nextPermutation(int[] nums) {
    if(nums.length == 0 || nums == null) return;
    Stack<Integer> stack = new Stack<>();
    for (int i = nums.length - 1; i > -1; i--) {
      if (stack.isEmpty() || stack.peek() <= nums[i]) {
        stack.push(nums[i]);
      } else {
        int j = nums.length - 1;
        while (!stack.isEmpty()) {
          int cur = stack.pop();
          if (cur > nums[i] && (stack.isEmpty() || stack.peek() <= nums[i])) {
            nums[j] = nums[i];
            nums[i] = cur;
          } else nums[j] = cur;
          j--;
        }
      }
    }
    if (!stack.isEmpty()) {
      for (int i = nums.length - 1; i > -1; i--) nums[i] = stack.pop();
    }
    return;
  }



  public static void main(String[] args){
    Prob31 prob31 = new Prob31();
    int[] nums = new int[]{1, 1, 5};
    prob31.nextPermutation(nums);
    prob31.showArray(nums);
    nums = new int[]{3,2,1};
    prob31.nextPermutation(nums);
    prob31.showArray(nums);
  }

  private void showArray(int[] nums){
    String s = "[";
    for(int i = 0; i < nums.length; i++){
      s += nums[i] + ", ";
    }
    s = s.substring(0, s.length() - 2);
    s += "]";
    System.out.println(s);

  }
}
