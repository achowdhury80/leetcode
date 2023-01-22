package com.prep2020.easy;

public class Problem1603 {
	private int[] availableSpaces;
	public Problem1603(int big, int medium, int small) {
		availableSpaces = new int[] {big, medium, small};
    }
    
	/**
	 * O(1)
	 * @param carType
	 * @return
	 */
    public boolean addCar(int carType) {
        if (availableSpaces[carType - 1] == 0) return false;
        availableSpaces[carType - 1]--;
        return true;
    }
}
