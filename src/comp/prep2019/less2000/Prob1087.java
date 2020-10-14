package comp.prep2019.less2000;
import java.util.*;
public class Prob1087 {
	public String[] expand(String S) {
        List<String> result = new ArrayList<>();
        result.add("");
        boolean started = false;
        String temp = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ',') continue;
        	if (S.charAt(i) == '{') {
        		started = true;
        		List<String> tempList = new ArrayList<>();
        		for (String str : result) tempList.add(str + temp);
        		temp = "";
        		result = tempList;
        	} else if (S.charAt(i) == '}') {
        		List<String> tempList = new ArrayList<>();
        		Collections.sort(list);
        		for (String s1 : result) {
        			for (String s2 : list) {
        				tempList.add(s1 + s2);
        			}
        			result = tempList;
        		}
                started = false;
                list.clear();
        	} else if (!started) {
        		temp += S.charAt(i);
        	} else {
        		list.add("" + S.charAt(i));
        	}
        }
        if (!"".equals(temp)) {
    		List<String> tempList = new ArrayList<>();
    		for (String str : result) tempList.add(str + temp);
    		temp = "";
    		result = tempList;
    	}
        String[] arr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) arr[i] = result.get(i);
        return arr;
    }
}
