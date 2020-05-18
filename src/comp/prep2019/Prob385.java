package comp.prep2019;
import java.util.*;

import com.leet.algo.NestedInteger;
public class Prob385 {
	public NestedInteger deserialize(String s) {
		if(!s.startsWith("[")) {
		      return new NestedInteger(Integer.parseInt(s));
		}
	    int listStartCount = 0;
	    String nextElement = "";
	    NestedInteger nestedInteger = new NestedInteger();
	    for (int i = 1; i < s.length() - 1; i++) {
	      char c = s.charAt(i);
	      if(listStartCount > 0) {
	        nextElement += c;
	        if (c == '[') listStartCount++;
	        else if (c == ']') listStartCount--;
	      } else {
	        if (c == '[') {
	          listStartCount++;
	          nextElement += c;
	        }
	        else if (c == ',') {
	          nestedInteger.add(deserialize(nextElement));
	          nextElement = "";
	        } else {
	          nextElement += c;
	        }
	      }
	    }
	    if(!nextElement.equals("")) nestedInteger.add(deserialize(nextElement));
	    return nestedInteger;
    }
}
