package com.leet.algo;

import java.util.List;

/**
 * Created by ayanc on 1/3/18.
 */
public interface NestedInteger {
  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();

           // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
           public Integer getInteger();

           // @return the nested list that this NestedInteger holds, if it holds a nested list
           // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
}
