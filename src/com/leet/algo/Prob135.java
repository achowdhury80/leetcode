package com.leet.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob135 {
  public int candy(int[] ratings) {
    int n;
    if (ratings == null || (n = ratings.length) < 1) return 0;
    int[] candies = new int[n];
    Arrays.fill(candies, 1);
    int sum = n;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < ratings.length; i++) {
      if (stack.isEmpty() || ratings[stack.peek()] > ratings[i]) stack.push(i);
      else {
        sum += clear(stack, ratings, candies);
        stack.push(i);
      }
    }
    sum += clear(stack, ratings, candies);
    return sum;
  }

  private int clear(Stack<Integer> stack, int[] ratings, int[] candies){
    int sum = 0;
    while (!stack.isEmpty()) {
      int index = stack.pop();
      if (index > 0 && ratings[index] > ratings[index - 1] && candies[index - 1] >= candies[index]) {
        candies[index] = candies[index - 1] + 1;
      }
      if (index < ratings.length - 1 && ratings[index] > ratings[index + 1] && candies[index] <= candies[index + 1]) {
        candies[index] = candies[index + 1] + 1;
      }
      sum += (candies[index] - 1);
    }
    return sum;
  }
  public int candy1(int[] ratings) {
    int n;
    if (ratings == null || (n = ratings.length) < 1) return 0;
    int[] candies = new int[n];
    Arrays.fill(candies, 1);
    int sum = n;
    for (int i = 1; i < candies.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        sum += candies[i - 1] + 1 - candies[i];
        candies[i] = candies[i - 1] + 1;
      }
    }
    for (int i = ratings.length - 1; i > 0; i--) {
      if (ratings[i] < ratings[i - 1]) {
        int newVal = Math.max(candies[i - 1], candies[i] + 1);
        sum += newVal - candies[i - 1];
        candies[i - 1] = newVal;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    Prob135 prob135 = new Prob135();
    System.out.println(prob135.candy(new int[]{1,2,1,4,5,2,2,3}));
  }
}
