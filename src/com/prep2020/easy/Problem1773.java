package com.prep2020.easy;
import java.util.*;
public class Problem1773 {
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int result = 0;
        for (List<String> item : items) {
        	switch (ruleKey) {
        	case "type":
        		if (ruleValue.equals(item.get(0))) result++;
        		break;
        	case "color":
        		if (ruleValue.equals(item.get(1))) result++;
        		break;
        	case "name":
        		if (ruleValue.equals(item.get(2))) result++;
        		break;
        	}
        }
        return result;
    }
}
