package com.prep2020.medium;

public class Problem393 {
	/**
	 * O(N)
	 * @param data
	 * @return
	 */
	public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
        	if ((data[i] >> 7) == 0) continue;
        	else if ((data[i] >> 5) == 6) {
        		if (!validate(data, i + 1, 1)) return false;
        		i += 1;
        	} else if ((data[i] >> 4) == 14) {
        		if (!validate(data, i + 1, 2)) return false;
        		i += 2;
        	} else if ((data[i] >> 3) == 30) {
        		if (!validate(data, i + 1, 3)) return false;
        		i += 3;
        	} else return false;
        }
        return true;
    }

	private boolean validate(int[] data, int start, int count) {
		if (start + count > data.length) return false;
		for (int i = 0; i < count; i++) {
			if ((data[start + i] >> 6) != 2) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem393 problem = new Problem393();
		System.out.println(problem.validUtf8(new int[] {197, 130, 1}));
	}
}
