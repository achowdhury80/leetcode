package comp.prep2019;
import java.util.*;
public class Prob555 {
	public String splitLoopedString(String[] strs) {
	    if (strs == null || strs.length < 1) return "";
	    for (int i = 0; i < strs.length; i++) {
	      String rev = new StringBuilder(strs[i]).reverse().toString();
	      if (strs[i].compareTo(rev) < 0) strs[i] = rev;
	    }
	    String result = "";
	    for (int i = 0; i < strs.length; i++) {
	      String rev = new StringBuilder(strs[i]).reverse().toString();
	      for (String st : new String[]{strs[i], rev}) {
	        for (int k = 0; k < st.length(); k++) {
	          StringBuilder sb = new StringBuilder(st.substring(k));
	          for (int j = i + 1; j < strs.length; j++) sb.append(strs[j]);
	          for (int j = 0; j < i; j++) sb.append(strs[j]);
	          sb.append(st.substring(0, k));
	          if (sb.toString().compareTo(result) > 0) result = sb.toString();
	        }
	      }
	    }
	    return result;
	  }
}	
