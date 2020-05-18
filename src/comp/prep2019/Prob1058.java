package comp.prep2019;

import java.util.HashMap;
import java.util.Map;

public class Prob1058 {
	/**
	 * start with 1st element and continue
	 * Maintain a map of sum and rounding error so far
	 * for each element add floor and ceil value to map each previous key
	 * @param prices
	 * @param target
	 * @return
	 */
	public String minimizeError(String[] prices, int target) {
        Map<Integer, Double> map = new HashMap<>();
        map.put(0, 0.0);
        for (int i = 0; i < prices.length; i++) {
        	double price = Double.parseDouble(prices[i]);
        	int upper = (int)Math.ceil(price);
        	int lower = (int)Math.floor(price);
        	Map<Integer, Double> newMap = new HashMap<>();
        	for (Map.Entry<Integer, Double> entry : map.entrySet()) {
        		int upperKey = entry.getKey() + upper;
        		int lowerKey = entry.getKey() + lower;
        		newMap.put(upperKey, Math.min(newMap.getOrDefault(upperKey, Double.MAX_VALUE), entry.getValue() + (upper - price)));
        		newMap.put(lowerKey, Math.min(newMap.getOrDefault(lowerKey, Double.MAX_VALUE), entry.getValue() + (price - lower)));
        	}
        	map = newMap;
        }
        
        if (map.containsKey(target)) {
        	return String.format("%.3f", map.get(target));
        }
        return "-1";
    }
	
	public static void main(String[] args) {
		Prob1058 prob = new Prob1058();
		System.out.println(prob.minimizeError(new String[] {"0.700","2.800","4.900"},
				8));
	}
}
