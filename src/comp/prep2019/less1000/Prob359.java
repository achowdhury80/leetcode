package comp.prep2019.less1000;
import java.util.*;
public class Prob359 {
	private Map<String, Integer> map;
	/** Initialize your data structure here. */
    public Prob359() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, 
     * otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.getOrDefault(message, Integer.MIN_VALUE) + 10 > timestamp) 
        	return false;
        map.put(message, timestamp);
        return true;
    }
}
