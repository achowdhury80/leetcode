package comp.prep2019;
import java.util.*;
public class Prob1408 {
	public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (x, y) -> y.length() - x.length()); 
        boolean[] notToBeChecked = new boolean[words.length];
        List<String> result = new ArrayList<>();
        for (int i = 1; i < words.length; i++) {
        	for (int j = 0; j < i; j++) {
        		if (notToBeChecked[j]) continue;
        		if (words[j].indexOf(words[i]) > -1) {
        			result.add(words[i]);
        			notToBeChecked[i] = true;
        			break;
        		}
        	}
        }
        return result;
    }
}
