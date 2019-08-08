package com.leet.algo;

public class Prob1108 {
	public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
        	if (c == '.') sb.append("[.]");
        	else sb.append(c);
        }
        return sb.toString();
    }
}
