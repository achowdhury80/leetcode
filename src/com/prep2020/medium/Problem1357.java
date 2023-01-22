package com.prep2020.medium;

import java.util.*;

public class Problem1357 {
	private int curNo, n, discount;
	private Map<Integer, Integer> priceMap;
	public Problem1357(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        priceMap = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
        	priceMap.put(products[i], prices[i]);
        }
    }
    
	public double getBill(int[] product, int[] amount) {
		curNo = (curNo + 1) % n;
        double result = 0;
        for (int i = 0; i < product.length; i++) {
        	double price = (curNo == 0 ? (100.0 - this.discount) / 100 : 1) 
        			* priceMap.get(product[i]);
        	result += price * amount[i];
        }
        return result;
    }
}
