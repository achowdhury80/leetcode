package com.prep2020.medium;
import java.util.*;
public class Problem1087 {
	public String[] expand(String s) {
        List<String> list = new ArrayList<>();
        list.add("");
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	List<String> temp = new ArrayList<>(); 
        	if (c != '{') {
        		temp.add("" + c);
        	} else {
        		String str = "";
        		i++;
        		while(s.charAt(i) != '}') str += s.charAt(i++);
        		String[] arr = str.split(",");
        		for (String st1 : arr) temp.add(st1);
        		Collections.sort(temp);
        	}
        	List<String> newList = new ArrayList<>();
        	for (String x : list) {
        		for (String y : temp) newList.add(x + y);
        	}
        	list = newList;
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
