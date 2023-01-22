package com.prep2020.easy;

public class Problem1859 {
	public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] result = new String[arr.length];
        for (String st : arr) {
        	int index = st.charAt(st.length() - 1) - '0';
        	result[index - 1] = st.substring(0, st.length() - 1);
        }
        return String.join(" ", result);
    }
}
