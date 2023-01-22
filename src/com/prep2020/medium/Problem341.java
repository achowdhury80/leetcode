package com.prep2020.medium;
import java.util.*;
public class Problem341 implements Iterator<Integer> {
	private List<NestedInteger> list;
	public Problem341(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for (NestedInteger ni : nestedList) list.add(ni);
    }

    @Override
    public Integer next() {
        if (hasNext()) return list.remove(0).getInteger();
        return -1;
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
        	List<NestedInteger> nestedList = list.remove(0).getList();
        	if (nestedList != null && !nestedList.isEmpty()) 
        	for (int i = nestedList.size() - 1; i > -1; i--) list.add(0, nestedList.get(i));
        }
        return !list.isEmpty();
    }
    
    public interface NestedInteger {
    	 
    	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
    	      public boolean isInteger();
    	 
    	      // @return the single integer that this NestedInteger holds, if it holds a single integer
    	      // Return null if this NestedInteger holds a nested list
    	      public Integer getInteger();
    	 
    	      // @return the nested list that this NestedInteger holds, if it holds a nested list
    	      // Return empty list if this NestedInteger holds a single integer
    	      public List<NestedInteger> getList();
    	  }
}
