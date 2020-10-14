package comp.prep2019.less2000;
import java.util.*;
public class Prob1357 {
	private int n, discount, count;
	private Map<Integer, Integer> priceMap;
	public Prob1357(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        priceMap = new HashMap<>();
        for (int i = 0; i < prices.length; i++) priceMap.put(products[i], prices[i]);
        count = 0;
    }
    
    public double getBill(int[] product, int[] amount) {
        count = (count + 1) % n;
        double result = 0;
        for (int i = 0; i < product.length; i++) {
        	double price = (count == 0 ? (100.0 - discount) / 100 : 1) 
        			* priceMap.get(product[i]);
        	result += price * amount[i];
        }
        return result;
    }
}
