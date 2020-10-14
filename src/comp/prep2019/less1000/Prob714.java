package comp.prep2019.less1000;

public class Prob714 {
	public int maxProfit(int[] prices, int fee) {
		if(prices == null || prices.length < 2) return 0;
	    long previousT_1 = Integer.MIN_VALUE;
	    long prviousT_0 = 0;
	    for(int i = 0; i < prices.length; i++){
	    	long temp = prviousT_0;
	    	prviousT_0 = Math.max(prviousT_0, previousT_1 + prices[i] - fee);
	    	previousT_1 = Math.max(previousT_1, temp - prices[i]);
	    }
	    return (int)prviousT_0;
    }
}
