package com.leet.algo;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob341 implements Iterator<Integer>{
  private Stack<NestedInteger> stack = null;
  public Prob341(List<NestedInteger> nestedList) {
    if(nestedList == null || nestedList.size() == 0) return;
    stack = new Stack<>();
    for(int i = nestedList.size() - 1; i > -1; i--) stack.push(nestedList.get(i));
    while(!stack.isEmpty()){
      NestedInteger nestedInteger = stack.pop();
      if(nestedInteger.isInteger()) {
        stack.push(nestedInteger);
        break;
      }
      else {
        List<NestedInteger> list = nestedInteger.getList();
        for (int i = list.size() - 1; i > -1; i--) {
          stack.push(list.get(i));
        }
      }
    }
  }

  @Override
  public Integer next() {
    Integer integer = stack.pop().getInteger();
    while(!stack.isEmpty()) {
      NestedInteger nestedInteger = stack.pop();
      if(nestedInteger.isInteger()) {
        stack.push(nestedInteger);
        break;
      }
      List<NestedInteger> list = nestedInteger.getList();
      for(int i = list.size() - 1; i > -1; i--){
        stack.push(list.get(i));
      }
    }
    return integer;
  }

  @Override
  public boolean hasNext() {
    return stack != null && !stack.isEmpty();
  }
}
