package com.leet.algo;
import java.util.*;
public class Prob381 {
	private List<Integer> list;
	private Map<Integer, Set<Integer>> valuePositionMap;
	private int count;
	private Random random;
	public Prob381() {
		list = new ArrayList<>();
		valuePositionMap = new HashMap<>();
		count = 0;
		random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean returnVal = false;
        if (!valuePositionMap.containsKey(val)) {
        	valuePositionMap.put(val, new HashSet<>());
        	returnVal = true;
        } 
        list.add(val);
        valuePositionMap.get(val).add(list.size() - 1);
        count++;
        return returnVal;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if (!valuePositionMap.containsKey(val)) return false;
    	int lastValIndex = list.size() - 1;
    	count--;
    	if (list.get(lastValIndex) == val) {
    		valuePositionMap.get(val).remove(lastValIndex);
    		list.remove(lastValIndex);
    		if (valuePositionMap.get(val).size() == 0) valuePositionMap.remove(val);
    		return true;
    	}
        int lastVal = list.get(lastValIndex);
        Set<Integer> lastValPostions = valuePositionMap.get(lastVal);
        Set<Integer> set =  valuePositionMap.get(val);
        int posToOverwrite = set.iterator().next();
        list.set(posToOverwrite, lastVal);
        list.remove(lastValIndex);
        lastValPostions.remove(lastValIndex);
        lastValPostions.add(posToOverwrite);
        set.remove(posToOverwrite);
        if (set.isEmpty()) valuePositionMap.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = random.nextInt(count); 
        return list.get(index);
    }
    
    public static void main(String[] args) {
    	Prob381 prob = new Prob381();
    	prob.insert(0);
    	prob.insert(1);
    	prob.insert(2);
    	prob.insert(3);
    	prob.insert(3);
    	System.out.println(prob.remove(2));
    	System.out.println(prob.remove(3));
    	System.out.println(prob.remove(0));
    	/*["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","getRandom","getRandom","getRandom","getRandom"]
    	[[],[0],[1],[2],[3],[3],[2],[3],[0],[],[],[],[]]*/
    }
}
