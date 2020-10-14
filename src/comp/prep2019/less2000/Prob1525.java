package comp.prep2019.less2000;
import java.util.*;
public class Prob1525 {
	public int numSplits(String s) {
		if (s.length() == 1) return 0;
        Map<Character, Integer> leftCharMap = new HashMap<>(),
        		rightCharMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	rightCharMap.put(c, rightCharMap.getOrDefault(c, 0) + 1);
        }
        int result = 0;
        for (int i = 0; i < s.length() - 1 
        		&& leftCharMap.size() <= rightCharMap.size(); i++) {
        	char c = s.charAt(i);
        	leftCharMap.put(c, leftCharMap.getOrDefault(c, 0) + 1);
        	rightCharMap.put(c, rightCharMap.get(c) - 1);
        	if (rightCharMap.get(c) == 0) rightCharMap.remove(c);
        	if (leftCharMap.size() == rightCharMap.size()) result++;
        }
        return result;
    }
}
