package com.prep2020.easy;
import java.util.*;
public class Problem1078 {
	public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>(), two = new ArrayList<>();
        for (String s : text.split(" ")) {
        	if (two.size() == 2 && two.get(0).equals(first) && two.get(1).equals(second)) {
        		result.add(s);
        	}
        	two.add(s);
        	if (two.size() > 2) two.remove(0);
        }
        String[] arr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) arr[i] = result.get(i);
        return arr;
    }
}
