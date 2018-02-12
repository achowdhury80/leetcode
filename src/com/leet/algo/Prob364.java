package com.leet.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob364 {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    Stack<NestedInteger> stack = new Stack<>();
    List<List<NestedInteger>> lists = new ArrayList<>();
    lists.add(nestedList);
    while (!lists.isEmpty()) {
      if (!stack.isEmpty()) stack.push(null);
      List<List<NestedInteger>> temp = new ArrayList<>();
      for (List<NestedInteger> list : lists) {
        for (NestedInteger nestedInteger : list) {
          if (nestedInteger.isInteger()) stack.push(nestedInteger);
          else temp.add(nestedInteger.getList());
        }
      }
      lists = temp;
    }
    int depth = 1;
    int result = 0;
    while (!stack.isEmpty()) {
      NestedInteger nestedInteger = stack.pop();
      if(nestedInteger == null) depth++;
      else result += depth * nestedInteger.getInteger();
    }
    return result;
  }

}
/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

 Example 1:
 Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

 Example 2:
 Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 */
