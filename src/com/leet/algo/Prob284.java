package com.leet.algo;

import java.util.Iterator;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob284 implements Iterator<Integer>{
  Integer peekInt = null;
  boolean collected = false;
  private Iterator<Integer> itr = null;
  public Prob284(Iterator<Integer> iterator) {
    // initialize any member here.
    itr = iterator;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    if(!collected){
      peekInt = itr.next();
      collected = true;
    }
    return peekInt;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if(collected){
      collected = false;
      return peekInt;
    }
    return itr.next();
  }

  @Override
  public boolean hasNext() {
    return collected ? true : itr.hasNext();
  }
}
