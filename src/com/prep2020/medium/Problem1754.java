package com.prep2020.medium;
import java.util.*;
public class Problem1754 {
	public String largestMerge(String word1, String word2) {
        String returnString = "";
        int i = 0, j = 0;
        final int index1 = word1.length();
        final int index2 = word2.length();
        while (i < index1 && j < index2) {
            if (word1.substring(i, index1).compareTo(word2.substring(j, index2)) < 0) {
                returnString += word2.charAt(j++);
            } else {
                returnString += word1.charAt(i++);
            }
        }
        if(i < index1) {
            returnString += word1.substring(i, index1);
        }
        if(j < index2) {
            returnString += word2.substring(j, index2);
        }
        return returnString;
    }
}
