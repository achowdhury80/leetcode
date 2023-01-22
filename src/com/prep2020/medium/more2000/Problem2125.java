package com.prep2020.medium.more2000;

public class Problem2125 {
	public int numberOfBeams(String[] bank) {
		int last = 0, result = 0;
        for (String row : bank) {
        	int count = findCount(row);
        	if (count > 0) {
        		if (last > 0) result += last * count;
        		last = count;
        	}
        }
        return result;
    }

	private int findCount(String row) {
		int result = 0;
		for (char c : row.toCharArray()) {
			if (c == '1') result++;
		}
		return result;
	}
	
}
