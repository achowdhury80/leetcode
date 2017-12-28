package com.leet.algo;

/**
 * Created by ayanc on 11/10/17.
 */
public class Prob31 {
  public void nextPermutation(int[] nums) {
    if(nums.length == 0 || nums == null) return;
    for(int i = nums.length - 2; i > -1; i--){
      if(permutate(nums, i)) return;
    }
    reverse(nums, 0);
  }

  private boolean permutate(int[] nums, int startIndex){
    int starIndexNum = nums[startIndex];
    for(int i = nums.length - 1; i > startIndex; i--){
      if(starIndexNum < nums[i]){
        int temp = starIndexNum;
        nums[startIndex] = nums[i];
        nums[i] = temp;
        for(int j = i; j < nums.length - 1; j++){
          if(nums[j] > nums[j - 1]){
            temp = nums[j];
            nums[j] = nums[j - 1];
            nums[j - 1] = temp;
          } else {
            break;
          }
        }
        reverse(nums, startIndex + 1);
        return true;
      }
    }
    return false;
  }

  private void reverse(int[] nums, int startIndex){
    for(int i = startIndex, j = nums.length - 1; j > i; i++, j--){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }

  public static void main(String[] args){
    Prob31 prob31 = new Prob31();
    int[] nums = new int[]{1, 1, 5};
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
