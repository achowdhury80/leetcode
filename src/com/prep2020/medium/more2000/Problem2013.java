package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2013 {
	
	private Map<Integer, List<int[]>> xMap, yMap;
	
	public Problem2013() {
        xMap = new HashMap<>();
        yMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<int[]> list = xMap.getOrDefault(point[0], new ArrayList<>());
        list.add(point);
        xMap.put(point[0], list);
        list = yMap.getOrDefault(point[1], new ArrayList<>());
        list.add(point);
        yMap.put(point[1], list);
    }
    
    public int count(int[] point) {
    	int result = 0;
        if (!xMap.containsKey(point[0]) || !yMap.containsKey(point[1])) return 0;
        List<int[]> sameXPoints = xMap.get(point[0]), sameYPoints = yMap.get(point[1]);
        Map<Integer, Integer> xDisMap = new HashMap<>(), yDisMap = new HashMap<>();
        for (int[] pt : sameXPoints) {
        	if (point[1] - pt[1] == 0) continue;
        	yDisMap.put(point[1] - pt[1], yDisMap.getOrDefault(point[1] - pt[1], 0) + 1);
        }
        for (int[] pt : sameYPoints) {
        	if (point[0] - pt[0] == 0) continue;
        	xDisMap.put(point[0] - pt[0], xDisMap.getOrDefault(point[0] - pt[0], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> xDisEntry : xDisMap.entrySet()) {
        	if (yDisMap.containsKey(xDisEntry.getKey())) {
        		int numberOfDiagonalPoints = findPoints(point[0] - xDisEntry.getKey(), point[1] - xDisEntry.getKey(), xMap);
        		result += xDisEntry.getValue() * yDisMap.get(xDisEntry.getKey()) * numberOfDiagonalPoints;
        	}
        	if (yDisMap.containsKey(-xDisEntry.getKey())) {
        		int numberOfDiagonalPoints = findPoints(point[0] - xDisEntry.getKey(), point[1] + xDisEntry.getKey(), xMap);
        		result += xDisEntry.getValue() * yDisMap.get(-xDisEntry.getKey()) * numberOfDiagonalPoints;
        	}
        }
        return result;
    }

	private int findPoints(int x, int y, Map<Integer, List<int[]>> xMap) {
		int result = 0;
		if (!xMap.containsKey(x)) return result;
		for (int[] pt : xMap.get(x)) {
			if (pt[1] == y) result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem2013 problem = new Problem2013();
		problem.add(new int[] {3, 10});
		problem.add(new int[] {11, 2});
		problem.add(new int[] {3, 2});
		System.out.println(problem.count(new int[] {11, 10}));
		System.out.println(problem.count(new int[] {14, 8}));
		problem.add(new int[] {11, 2});
		System.out.println(problem.count(new int[] {11, 10}));
	}
}
