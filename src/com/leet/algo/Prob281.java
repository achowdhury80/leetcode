package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob281 {
  private List<Iterator<Integer>> lists;
  public Prob281(List<Integer> v1, List<Integer> v2) {
    lists = new ArrayList<>();
    if (v1.iterator().hasNext()) lists.add(v1.iterator());
    if (v2.iterator().hasNext()) lists.add(v2.iterator());
  }

  public boolean hasNext() {
    return !lists.isEmpty();
  }

  public int next() {
    Iterator<Integer> itr = lists.remove(0);
    int result = itr.next();
    if (itr.hasNext()) lists.add(lists.size(), itr);
    return result;
  }

  public static void main(String[] args) {
    Prob281 prob281 = new Prob281(Arrays.asList(1, 2), Arrays.asList(3,4, 5,6));
    while (prob281.hasNext()) System.out.println(prob281.next());
  }
}
/**
 * Zigzag Iterator
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:

 v1 = [1, 2]
 v2 = [3, 4, 5, 6]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

 Clarification for the follow up question - Update (2015-09-18):
 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

 [1,2,3]
 [4,5,6,7]
 [8,9]
 It should return [1,4,8,2,5,9,3,6,7].

 */
