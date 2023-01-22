package com.prep2020.medium;

import java.util.Arrays;

public class Problem1451 {
	public String arrangeWords(String text) {
        String[] arr = text.split(" ");
        Arrays.sort(arr, (x, y) -> (x.length() - y.length()));
        String result = "";
        for (String s : arr) result += " " + s.toLowerCase();
        result = "" + Character.toUpperCase(result.charAt(1)) + result.substring(2);
        return result;
    }
}
