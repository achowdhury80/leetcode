package com.prep2020.easy;
import java.util.*;
public class Problem2194 {
	public List<String> cellsInRange(String s) {
        String[] arr = s.split(":");
        List<String> result = new ArrayList<>();
        for (char c = arr[0].charAt(0); c <= arr[1].charAt(0); c++) {
        	for (int i = (arr[0].charAt(1) - '0'); 
        			i <= (arr[1].charAt(1) - '0'); i++)
        		result.add("" + c + "" + i);
        }
        return result;
    }
}
