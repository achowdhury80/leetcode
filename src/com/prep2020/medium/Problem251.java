package com.prep2020.medium;

public class Problem251 {
	private int[][] vec;
	private int[] cur = new int[] {-1, -1};
	public Problem251(int[][] vec) {
        this.vec = vec;
        boolean found = false;
        for (int i = 0; i < vec.length; i++) {
        	for (int j = 0; j < vec[i].length; j++) {
        		cur = new int[] {i, j};
        		found = true;
        		break;
        	}
        	if (found) break;
        }
    }
    
    public int next() {
        int result = vec[cur[0]][cur[1]];
        int[] temp = cur;
        cur = new int[] {-1, -1};
        boolean found = false;
        for (int i = temp[0]; i < vec.length; i++) {
        	for (int j = 0; j < vec[i].length; j++) {
        		if (i == temp[0] && j <= temp[1]) continue;
        		cur = new int[] {i, j};
        		found = true;
        		break;
        	}
        	if (found) break;
        }
        return result;
    }
    
    public boolean hasNext() {
        return cur[0] != -1;
    }
    
    public static void main(String[] args) {
    	Problem251 problem = new Problem251(new int[][] {{1,2}, {3}, {4}});
    	System.out.println(problem.next());
    	System.out.println(problem.next());
    	System.out.println(problem.next());
    	System.out.println(problem.hasNext());
    	System.out.println(problem.hasNext());
    	System.out.println(problem.next());
    	System.out.println(problem.hasNext());
    }
}
