package com.prep2020.easy;
import java.util.*;
public class Problem1496 {
	public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        visited.add("0:0");
        int[] cur = new int[] {0, 0};
        for (char c : path.toCharArray()) {
        	switch(c) {
        		case 'N': 
        			cur[1]++;
        			break;
        		case 'S':
        			cur[1]--;
        			break;
        		case 'W':
        			cur[0]--;
        			break;
        		case 'E':
        			cur[0]++;
        			break;
        	}
        	
        	String pos = "" + cur[0] + ":" + cur[1];
        	if (visited.contains(pos)) return true;
        	visited.add(pos);
        }
        return false;
    }
	
	public static void main(String[] args) {
		Problem1496 problem = new Problem1496();
		System.out.println(problem.isPathCrossing("WSSESEEE"));
	}
}
