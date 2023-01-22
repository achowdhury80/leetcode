package com.prep2020.medium.more2000;

import java.text.DecimalFormat;

public class Problem2288 {
	public String discountPrices(String sentence, int discount) {
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        double discountMultiplier = 1d - (discount + 0.0) / 100;
        for (String w : arr) {
        	sb.append(" ");
        	if (isPrice(w)) sb.append(applyDiscount(w, discountMultiplier));
        	else sb.append(w);
        }
        return sb.toString().substring(1);
    }
	
	private String applyDiscount(String w, double discountMultiplier) {
		DecimalFormat df = new DecimalFormat("0.00");

		double val = Double.parseDouble(w.substring(1));
		val *= discountMultiplier;
		return "$" + df.format(val);
	}

	private boolean isPrice(String w) {
		if (w.length() < 2 || !w.startsWith("$")) return false;
		if (w.charAt(1) == '0' && w.length() > 2) return false;
		boolean decimalFound = false;
		for (int i = 1; i < w.length(); i++) {
			char c = w.charAt(i);
			if (c == '.') {
				if (decimalFound) return false;
				decimalFound = true;
			} else if (!Character.isDigit(c)) return false;
		}
		return true;
	}
}
