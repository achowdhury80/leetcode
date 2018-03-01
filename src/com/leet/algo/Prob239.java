package com.leet.algo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length < 1 || k < 1) return new int[0];
    int[] result = new int[nums.length - k + 1];
    int index = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
      deque.offer(i);
      if (i + 1 >= k) result[index++] = nums[deque.peek()];
    }
    return result;
  }

  public static void main(String[] args) {
    Prob239 prob239 = new Prob239();
    System.out.println(prob239.maxSlidingWindow(new int[]{1}, 1));
  }
}
