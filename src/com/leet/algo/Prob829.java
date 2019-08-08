package com.leet.algo;
import java.util.*;
public class Prob829 {
	public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails) {
        	char[] arr = email.toCharArray();
        	StringBuilder sb = new StringBuilder();
        	boolean ignore = false;
        	boolean domain = false;
        	for (int i = 0; i < arr.length; i++) {
        		char c = arr[i];
        		if (c == '@') {
        			domain = true;
        		}
        		if (domain) {
        			sb.append(c);
        		} else if (!ignore) {
        			if (c == '+') ignore = true;
        			else if (c != '.')sb.append(c);
        		}
        	}
        	set.add(sb.toString());
        		
        }
        return set.size();
    }
}
