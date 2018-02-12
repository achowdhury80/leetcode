package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob281 {
  private List<List<Integer>> lists;
  private int[] current = null;
  public Prob281(List<Integer> v1, List<Integer> v2) {
    List<List<Integer>> lists = new ArrayList<>();
    if (!v1.isEmpty()) {
      lists.add(v1);
      current = new int[2];
    }
    if (!v2.isEmpty()){
      lists.add(v2);
      if(current == null) current = new int[2];
    }
    this.lists = lists;

  }

  public Prob281(List<List<Integer>> lists) {
    this.lists = lists;
  }

  public int next() {
    int result = lists.get(current[0]).get(current[1]);
    current = nextPosition();
    return result;
  }

  private int[] nextPosition(){
    int[] nextRowColumn = findNextRowNColumn(current);
    while (nextRowColumn[0] != current[0]) {
      if(lists.get(nextRowColumn[0]).size() > nextRowColumn[1]) return nextRowColumn;
      nextRowColumn = findNextRowNColumn(nextRowColumn);
    }
    if (lists.get(nextRowColumn[0]).size() > nextRowColumn[1]) return nextRowColumn;
    return null;
  }

  private int[] findNextRowNColumn(int[] current){
    if (current[0] + 1 == lists.size()) return new int[]{0, current[1] + 1};
    return new int[] {current[0] + 1, current[1]};
  }

  public boolean hasNext() {
    return current != null;
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
