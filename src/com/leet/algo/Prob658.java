package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/17/18.
 */
public class Prob658 {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();

    int closestIndex = findClosest(arr, x, 0, arr.length - 1);
    result.add(arr[closestIndex]);
    k--;
    int leftIndex = closestIndex - 1;
    int rightIndex = closestIndex + 1;
    while(k > 0 && leftIndex > -1 && rightIndex < arr.length){
      int nextClosestIndex = findClosestNumber(arr, leftIndex, rightIndex, x);
      result.add((nextClosestIndex == leftIndex ? 0 : result.size()), arr[nextClosestIndex]);
      k--;
      if(nextClosestIndex == leftIndex){
        leftIndex--;
      } else {
        rightIndex++;
      }
    }
    if(k > 0){
      if(leftIndex > 0){
        while (k > 0){
          result.add(0, arr[leftIndex]);
          leftIndex--;
          k--;
        }
      } else {
        while (k > 0){
          result.add(arr[rightIndex]);
          rightIndex++;
          k--;
        }
      }
    }

    return result;
  }

  private int findClosest(int[] arr, int x, int start, int end){
    if(start == end) return start;
    int mid = (start + end) / 2;
    if(arr[mid] == x) return mid;
    if(arr[mid + 1] == x) return mid + 1;
    if(mid == 0){
      return findClosestNumber(arr, 0, 1, x);
    }
    if(arr[mid - 1] == x) return mid - 1;
    if(x > arr[mid] && x < arr[mid + 1]){
      return findClosestNumber(arr, mid, mid + 1, x);
    } else if(x < arr[mid] && x > arr[mid - 1]){
      return findClosestNumber(arr, mid, mid - 1, x);
    } else if(arr[mid] > x){
      return findClosest(arr, x, start, mid - 1);
    } else {
      return findClosest(arr, x, mid + 1, end);
    }
  }

  private int findClosestNumber(int[] nums, int leftIndex, int rightIndex, int x){
    if(Math.abs(nums[leftIndex] - x) <= Math.abs(nums[rightIndex] - x)) return leftIndex;
    return rightIndex;
  }


  public static void main(String[] arhs){
    Prob658 prob658 = new Prob658();
    System.out.println(prob658.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
    System.out.println(prob658.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
  }
}
