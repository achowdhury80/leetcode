package com.prep2020.medium;
import java.util.*;
public class Problem1333 {
	/**
	 * O(nLogN) time and O(N) space
	 * @param restaurants
	 * @param veganFriendly
	 * @param maxPrice
	 * @param maxDistance
	 * @return
	 */
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> filteredList = new ArrayList<>();
        for (int[] res : restaurants) {
        	if ((veganFriendly == 0 || res[2] == veganFriendly) && res[3] <= maxPrice && res[4] <= maxDistance) filteredList.add(res);
        }
        Collections.sort(filteredList, (x, y) -> x[1] == y[1] ? (y[0] - x[0]) : (y[1] - x[1]));
        List<Integer> result = new ArrayList<>();
        for (int[] arr : filteredList) result.add(arr[0]);
        return result;
	}
}
