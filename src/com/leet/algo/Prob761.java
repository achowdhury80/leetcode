package com.leet.algo;
import java.util.*;
public class Prob761 {
	public String makeLargestSpecial(String S) {
        List<String> list = new ArrayList<>();
        char[] arr = S.toCharArray();
        int count = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
        	if(arr[i] == '1') count++;
        	else count--;
        	if (count == 0) {
        		list.add('1' + makeLargestSpecial(S.substring(j + 1, i)) + '0');
        		j = i + 1;
        	}
        }
        Collections.sort(list, Collections.reverseOrder());
        return String.join("", list);
    }
}
