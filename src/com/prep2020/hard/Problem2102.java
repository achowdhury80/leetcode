package com.prep2020.hard;
import java.util.*;
public class Problem2102 {
	private List<NameScore> list;
	private int curCount = -1;
	public Problem2102() {
        list = new ArrayList<>();
    }
    
    public void add(String name, int score) {
    	NameScore ns = new NameScore(name, score);
    	int idx = Collections.binarySearch(list, ns);
    	idx = -(idx + 1);
    	list.add(idx, ns);
    }
    
    public String get() {
    	curCount++;
        return list.get(curCount).name;
    }
    
    class NameScore implements Comparable<NameScore>{
    	public NameScore(String name, int score) {
			super();
			this.name = name;
			this.score = score;
		}
		String name;
    	int score;
		@Override
		public int compareTo(NameScore o) {
			return this.score == o.score ? this.name.compareTo(o.name) : (o.score - this.score);
		}
    	
    }
}
