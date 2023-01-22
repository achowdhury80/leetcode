package com.prep2020.easy;

public class Problem1232 {
	public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;
        boolean yParalel = false;
        double slope = (coordinates[0][1] - coordinates[1][1] + 0.) / (coordinates[0][0] - coordinates[1][0]);
        if (coordinates[0][0] == coordinates[1][0]) yParalel = true;
        for (int i = 2; i < coordinates.length; i++) {
        	if (yParalel) {
        		if (coordinates[i][0] != coordinates[i - 1][0]) return false;
        	} else {
        		if ((coordinates[i - 1][1] - coordinates[i][1] + 0.) 
        				/ (coordinates[i - 1][0] - coordinates[i][0]) != slope) return false;
        	}
        }
        return true;
    }
}
