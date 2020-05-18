package comp.prep2019;
import java.util.*;
public class Prob284 implements Iterator<Integer>{
	private boolean peakRetrieved;
	private int peek;
	private Iterator<Integer> iterator;
	public Prob284(Iterator<Integer> iterator) {
	    // initialize any member here.
		peakRetrieved = false;
		this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peakRetrieved) return peek;
        peek = iterator.next();
        peakRetrieved = true;
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(peakRetrieved) {
			peakRetrieved = false;
			return peek;
		}
		return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    return peakRetrieved || iterator.hasNext();
	}
}
