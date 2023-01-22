package com.prep2020.easy;

public class Problem657 {
	/**
	 * O(N)
	 * @param moves
	 * @return
	 */
	public boolean judgeCircle(String moves) {
        int horizontal = 0, vertical = 0;
        for (char c : moves.toCharArray()) {
        	switch(c) {
        		case 'U' : 
	        		vertical++;
	        		break;
        		case 'D' : 
        			vertical--;
	        		break;
        		case 'L' : 
        			horizontal--;
	        		break;
        		case 'R' : 
        			horizontal++;
	        		break;
        	}
        }
        return horizontal == 0 && vertical == 0;
    }

}
