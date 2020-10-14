package comp.prep2019.less1000;
import java.util.*;
public class Prob816 {
	public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < S.length() - 1; i++) {
        	String left = S.substring(0, i + 1);
        	String right = S.substring(i + 1);
        	List<String> l1 = findVariants(left);
        	if (l1.isEmpty()) continue;
        	List<String> l2 = findVariants(right);
        	if (l2.isEmpty()) continue;
        	for (String s1 : l1) {
        		for(String s2 : l2) {
        			result.add("(" + s1 + ", " + s2 + ")");
        		}
        	}
        }
        return result;
    }
	
	private List<String> findVariants(String s) {
		if (s.startsWith("0") && s.endsWith("0")) return new ArrayList<>();
		List<String> result = new ArrayList<>();
		if (s.length() == 1 || s.endsWith("0")) {
			result.add(s);
			return result;
		}
		if (s.startsWith("0")) {
			result.add("0." + s.substring(1));
			return result;
		} 
		result.add(s);
		for (int i = 1; i < s.length(); i++) {
			result.add(s.substring(0, i) + "." + s.substring(i));
		}
		return result;
	}
}
