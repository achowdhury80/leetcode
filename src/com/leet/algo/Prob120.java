package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 12/19/17.
 */
public class Prob120 {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n;
    if(triangle == null || (n = triangle.size()) == 0) return 0;
    int[] dp = new int[n];
    for(int i = 0; i < n; i++){
      int last = 0;
      for(int j = 0; j < triangle.get(i).size(); j++){
        int listSize = triangle.get(i).size();
        int elem = triangle.get(i).get(j);
        int temp = -1;
        if(j == 0){
          temp = dp[j] + elem;
        } else if(j + 1 == listSize){
          temp = dp[j - 1] + elem;
        } else {
          temp = Math.min(dp[j - 1] + elem, dp[j] + elem);
        }
        if(j > 0) dp[j - 1] = last;
        last = temp;
      }
      dp[triangle.get(i).size() - 1] = last;
    }
    int result = Integer.MAX_VALUE;
    for(int i = 0; i < dp.length; i++){
      result = Math.min(result, dp[i]);
    }
    return result;
  }

  private int findMin(int... ints){
    int result = Integer.MAX_VALUE;
    for(int i = 0; i < ints.length; i++){
      result = Math.min(result, ints[i]);
    }
    return result;
  }
  public static void main(String[] arge){
    Prob120 prob120 = new Prob120();
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    list1.add(2);
    list.add(list1);

    List<Integer> list2 = new ArrayList<>();
    list2.add(3);
    list2.add(4);
    list.add(list2);

    List<Integer> list3 = new ArrayList<>();
    list3.add(6);
    list3.add(5);
    list3.add(7);
    list.add(list3);

    List<Integer> list4 = new ArrayList<>();
    list4.add(4);
    list4.add(1);
    list4.add(8);
    list4.add(3);
    list.add(list4);


    System.out.println(prob120.minimumTotal(list));
  }
}
