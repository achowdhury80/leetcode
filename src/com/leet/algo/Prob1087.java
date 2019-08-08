package com.leet.algo;
import java.util.*;
public class Prob1087 {
	public String[] expand(String S) {
        String[] arr = S.split("[{}]");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i].indexOf(',') > - 1) {
        		String[] strs = arr[i].split(",");
        		List<String> temp = new ArrayList<>();
        		for (int k = 0; k < strs.length; k++) {
        			if (list.isEmpty()) {
        				temp.add(strs[k]);
        			} else {
	        			for (int j = 0; j < list.size(); j++) {
	            			temp.add(list.get(j) + strs[k]);
	            		}
        			}
        		}
        		list = temp;
        	} else {
        		if(list.isEmpty()) list.add(arr[i]);
        		else {
	        		for (int j = 0; j < list.size(); j++) {
	        			list.set(j, list.get(j) + arr[i]);
	        		}
        		}
        	}
        }
        Collections.sort(list);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
