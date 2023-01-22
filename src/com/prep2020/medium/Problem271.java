package com.prep2020.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem271 {
	// Encodes a list of strings to a single string.
		  public String encode(List<String> strs) {
		    char sep = (char)256;
		    StringBuilder sb = new StringBuilder();
		    for (String s : strs){
		      sb.append(s);
		      sb.append(sep);
		    }
		    return sb.toString();
		  }

		  // Decodes a single string to a list of strings.
		  public List<String> decode(String s) {
		    char sep = (char)256;
		    List<String> result = new ArrayList<>();
		    int idx = - 1;
		    int temp;
		    while((temp = s.indexOf(sep, idx + 1)) > - 1) {
		      result.add(s.substring(idx + 1, temp));
		      idx = temp;
		    }
		    return result;
		  }
}
