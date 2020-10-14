package comp.prep2019.less2000;
import java.util.*;
public class Prob1324 {
	/**
	 * O(n* maxLength of each string) & O(1) space
	 * @param s
	 * @return
	 */
	public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        // maintains the strings which needs not to be checked
        // if removed[i] true then all the subsequent strings are also removed
        boolean[] removed = new boolean[arr.length];
        int i = 0;
        List<String> result = new ArrayList<>();
        // maintains the last valid string
        int last = arr.length - 1;
        // continue till the first string is removed
        while(!removed[0]) {
        	StringBuilder sb = new StringBuilder();
        	// for each string
        	for (int j = 0; j < arr.length; j++) {
        		if (!removed[j] && i < arr[j].length()) sb.append(arr[j].charAt(i));
        		else {
        			// append whitespace
        			sb.append(" ");
        			//if last string and nothing to add, then remove the string
        			if (j == last) {
        				removed[j] = true;
        				last--;
        				// remove the previous string which does not have anything to add
        				for(int k = j - 1; k > -1; k--) {
            				if (arr[k].length() == i + 1) {
            					removed[k] = true;
            					last--;
            				}
            				else break;
            			}
        			}
        		}
        	}
        	// remove trailing whitespace
        	String st = sb.toString().stripTrailing();
        	if ("".equals(st)) break;
        	result.add(st);
        	i++;
        }
        return result;
    }
}
