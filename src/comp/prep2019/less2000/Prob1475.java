package comp.prep2019.less2000;
import java.util.*;

public class Prob1475 {
	/**
	 * O(N)
	 * @param prices
	 * @return
	 */
	public int[] finalPrices(int[] prices) {
		// top has max, and decreasing
		Stack<Integer> maxStack = new Stack<>();
        for (int i = prices.length - 1; i > -1; i--) {
        	while(!maxStack.isEmpty() && maxStack.peek() > prices[i]) maxStack.pop();
        	int temp = prices[i];
        	if (!maxStack.isEmpty()) prices[i] -= maxStack.peek();
        	if (maxStack.isEmpty() || maxStack.peek() < temp) 
        		maxStack.push(temp);
        }
        return prices;
    }
}
