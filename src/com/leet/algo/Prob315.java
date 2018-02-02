package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/1/18.
 */
public class Prob315 {
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length < 1) return result;
    TreeNode root = new TreeNode(nums[nums.length - 1]);
    result.add(0);
    for (int i = nums.length - 2; i > -1; i--) {
      result.add(0, insert(root, nums[i], 0));
    }
    return result;
  }

  class TreeNode {
    int val;
    int count = 1;
    TreeNode left;
    TreeNode right;
    int valCount = 1;
    TreeNode(int val){
      this.val = val;
    }
  }

  private int insert(TreeNode root, int num, int presum){
    if(num == root.val){
      root.count++;
      root.valCount++;
      return presum + root.count - root.valCount;
    }
    if (num < root.val){
      root.count++;
      //incrementCounts(root.right);
      if(root.left == null){
        root.left = new TreeNode(num);
        return presum;
      }
      else return insert(root.left, num, presum);
    } else {
      presum = presum + root.count;
      if (root.right == null) {
        root.right = new TreeNode(num);
        return presum;
      } else {
        return insert(root.right, num, presum);
      }
    }
  }


  public static void main(String[] args){
    Prob315 prob315 = new Prob315();
//    System.out.println(prob315.countSmaller(new int[]{5, 2, 6, 1}));
    System.out.println(prob315.countSmaller(new int[]{2, 1, 0}));
//    System.out.println(prob315.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,
//        78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
  }
}
