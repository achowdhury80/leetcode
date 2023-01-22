package com.prep2020.hard;

public class Problem1274 {
	/**
	 * O(MlogM * NlogN)
	 * m and n is horizontal and vertical width respectively
	 * @param sea
	 * @param topRight
	 * @param bottomLeft
	 * @return
	 */
	public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (topRight[0] == bottomLeft[0]) {
        	return verticalShipCalculation(sea, topRight, bottomLeft);
        }
        int mid = (topRight[0] + bottomLeft[0]) / 2;
        int leftCount = 0;
        if (sea.hasShips(new int[] {mid, topRight[1]}, bottomLeft)) {
        	leftCount = countShips(sea, new int[] {mid, topRight[1]}, bottomLeft);
        }
        if (leftCount > 9) return leftCount;
        int rightCount = 0;
        if (sea.hasShips(topRight, new int[] {mid + 1, bottomLeft[1]})) {
        	rightCount = countShips(sea, topRight, new int[] {mid + 1, bottomLeft[1]});
        }
        return leftCount + rightCount;
    }
	
	private int verticalShipCalculation(Sea sea, int[] topRight, int[] bottomLeft) {
		if (topRight[1] == bottomLeft[1]) {
			return sea.hasShips(topRight, bottomLeft) ? 1 : 0;
		}
		int mid = (topRight[1] + bottomLeft[1]) / 2;
		int upCount = 0;
        if (sea.hasShips(topRight, new int[] {bottomLeft[0], mid + 1})) {
        	upCount = verticalShipCalculation(sea, topRight, new int[] {bottomLeft[0], mid + 1});
        }
        if (upCount > 9) return upCount;
        int downCount = 0;
        if (sea.hasShips(new int[] {topRight[0], mid}, bottomLeft)) {
        	downCount = verticalShipCalculation(sea, new int[] {topRight[0], mid}, bottomLeft);
        }
        return upCount + downCount;
	}

	class Sea {
		      public boolean hasShips(int[] topRight, int[] bottomLeft) {
		    	  return true;
		      }
		 }
}
