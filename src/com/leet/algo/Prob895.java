package com.leet.algo;
import java.util.*;
public class Prob895 {
	private Map<Integer, List<Integer>> freqToNumMap;
	private Map<Integer, Integer> numToFreqMap;
	int maxFreq;
	public Prob895() {
		freqToNumMap = new HashMap<>();
		numToFreqMap = new HashMap<>();
		maxFreq = 0;
    }
    
    public void push(int x) {
        int curFreq = numToFreqMap.getOrDefault(x, 0);
        curFreq++;
        numToFreqMap.put(x, curFreq);
        if (!freqToNumMap.containsKey(curFreq)) freqToNumMap.put(curFreq, new ArrayList<>());
        freqToNumMap.get(curFreq).add(x);
        maxFreq = Math.max(maxFreq, curFreq);
    }
    
    public int pop() {
        if (maxFreq == 0) return -1;
        List<Integer> list = freqToNumMap.get(maxFreq);
        int x = list.remove(list.size() - 1);
        numToFreqMap.put(x, numToFreqMap.get(x) - 1);
        if (numToFreqMap.get(x) == 0) numToFreqMap.remove(x);
        if (list.size() == 0) {
        	freqToNumMap.remove(maxFreq);
        	maxFreq--;
        }
        return x;
    }
}
