package com.prep2020.medium;

import java.util.Iterator;

public class Problem284 implements Iterator<Integer> {
	private int peek = -1;
	private Iterator<Integer> iterator;
	public Problem284(Iterator<Integer> iterator) {
	    this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (peek == -1) peek = iterator.next();
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (peek != -1) {
	    	int result = peek;
	    	peek = -1;
	    	return result;
	    }
	    return iterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    return peek != -1 || iterator.hasNext();
	}
}
