package com.leet.algo;

import java.util.List;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob339 {
  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }
  public int depthSum(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) sum += depth * nestedInteger.getInteger();
      else sum += depthSum(nestedInteger.getList(), depth + 1);
    }
    return sum;
  }
}
