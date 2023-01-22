package com.prep2020.medium.more2000;
public class Problem2075 {
	public String decodeCiphertext(String encodedText, int rows) {
	    int sz = encodedText.length(), cols = sz / rows;
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < cols; ++i)
	        for (int j = i; j < sz; j += cols + 1)
	            sb.append(encodedText.charAt(j));
	    return sb.toString().stripTrailing();
	}
}
