package com.prep2020.easy;

public class Problem925 {
	public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while(i < name.length()) {
        	if (j == typed.length() || typed.charAt(j) != name.charAt(i)) return false;
        	int k = i;
        	while(k + 1 < name.length() && name.charAt(k + 1) == name.charAt(i)) k++;
        	int m = j;
        	while(m + 1 < typed.length() && typed.charAt(m + 1) == typed.charAt(j)) m++;
        	if (m - j < k - i) return false;
        	i = k + 1;
        	j = m + 1;
        }
        if (j < typed.length()) return false;
        return true;
    }
}
