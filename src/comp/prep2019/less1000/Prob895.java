package comp.prep2019.less1000;
import java.util.*;
public class Prob895 {
	private Map<Integer, Integer> numToFreqMap;
	private Map<Integer, List<Integer>> freqToNumMap;
	private int maxFreq;
	public Prob895() {
		numToFreqMap = new HashMap<>();
		freqToNumMap = new HashMap<>();
    }
    
    public void push(int x) {
    	int curFreq = numToFreqMap.getOrDefault(x, 0) + 1;
    	maxFreq = Math.max(maxFreq, curFreq);
    	numToFreqMap.put(x, curFreq);
    	List<Integer> list = freqToNumMap.getOrDefault(curFreq, new ArrayList<>());
    	list.add(0, x);
    	freqToNumMap.put(curFreq, list);
    }
    
    public int pop() {
    	List<Integer> list = freqToNumMap.get(maxFreq);
    	int num = list.remove(0);
    	if (maxFreq == 1) {
    		numToFreqMap.remove(num);
    	} else numToFreqMap.put(num, maxFreq - 1);
    	if (list.isEmpty()) {
    		freqToNumMap.remove(maxFreq);
    		maxFreq--;
    		while(maxFreq > 0 && !freqToNumMap.containsKey(maxFreq)) maxFreq--;
    	} 
    	return num;
    }
}
