package comp.prep2019;

import java.util.Arrays;

public class Prob1433 {
	public boolean checkIfCanBreak(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int bigger = 0;
        for (int i = 0; i < arr1.length; i++) {
        	if (arr1[i] > arr2[i]) {
        		if (bigger == 2) return false;
        		bigger = 1;
        	} else if (arr1[i] < arr2[i]) {
        		if (bigger == 1) return false;
        		bigger = 2;
        	}
        }
        return true;
    }
}
