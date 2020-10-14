package comp.prep2019.less1000;
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
    		for (String s : new String[] {strs[i], rev}) {
    			for (int k = 0; k < strs[i].length(); k++) {
    				StringBuilder sb = new StringBuilder(s.substring(k));
    				for (int j = i + 1; j < strs.length; j++) sb.append(strs[j]);
    				for (int j = 0; j < i; j++) sb.append(strs[j]);
    				sb.append(s.substring(0, k));
    				String st = sb.toString();
    				if ("".equals(result)) result = st;
    				else if (result.compareTo(st) < 0) result = st;
    			}
    		}
    	}
    	return result;
    }
}	
