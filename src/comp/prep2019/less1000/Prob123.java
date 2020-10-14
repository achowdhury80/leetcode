package comp.prep2019.less1000;
import java.util.*;
public class Prob123 {
	/**
	 * o(n) time and space
	 * First pass find best profit case for each day and keep the info in the list
	 * Then go reverse from the end by keeping track of maxPrice
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
        List<Integer> firstBuySellProfit = new ArrayList<>();
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
        	maxProfit = Math.max(maxProfit, price - minPrice);
        	firstBuySellProfit.add(maxProfit);
        	minPrice = Math.min(minPrice, price);
        }
        int maxPriceSoFar = 0;
        for (int i = prices.length - 1; i > 0; i--) {
        	maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
        	maxProfit = Math.max(maxProfit, 
        			maxPriceSoFar - prices[i] + firstBuySellProfit.get(i - 1));
        }
        return maxProfit;
    }	
}
