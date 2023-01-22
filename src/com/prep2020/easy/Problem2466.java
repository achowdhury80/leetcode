package com.prep2020.easy;

public class Problem2466 {
	public boolean haveConflict(String[] event1, String[] event2) {
		if(event1[0].compareTo(event2[0])==0 || event1[1].compareTo(event2[1])==0) return true;
	    
	    else if(event1[0].compareTo(event2[0])<=0 && event1[1].compareTo(event2[0])>=0) return true;
	    
	    else if(event1[0].compareTo(event2[0])>=0 && event1[0].compareTo(event2[1])<=0) return true;

	    
	    return false;
    }
}
