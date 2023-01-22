package com.prep2020.medium.more2000;

import java.util.*;

public class Problem2250 {
	 public int[] countRectangles(int[][] rectangles, int[][] points) {
	        Arrays.sort(rectangles, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
	      
	        HashMap<Integer, List<Integer>>  yMap = new HashMap<>();
	        for(int i=0; i<rectangles.length; i++){
	            yMap.computeIfAbsent(rectangles[i][1], k -> new ArrayList<>()).add(rectangles[i][0]);
	        }
	        
	        int[] ans = new int[points.length];
	        for(int i=0; i<points.length; i++){
	        if(points[i][0] > rectangles[rectangles.length-1][0]) continue;
	            
	            int count = 0;
	            for(int j=points[i][1]; j<=100; j++){
	                if(!yMap.containsKey(j)) continue;
	                
	                int xIndex = findXIndex(yMap.get(j), points[i][0]);
	                if(xIndex == -1) continue;
	                count += yMap.get(j).size() - xIndex;
	            }
	            
	            ans[i] = count;
	        }
	        
	        return ans;
	    }
	    
	    private int findXIndex(List<Integer> li, int key){
	        if(li.get(li.size()-1) < key) return -1;

	        int l = 0;
	        int h = li.size() - 1;

	        while(l < h){
	            int m = l + (h-l)/2;
	            if(li.get(m) < key){
	                l = m+1;
	            }else h = m;
	        }
	        
	        return l;
	    }
}
