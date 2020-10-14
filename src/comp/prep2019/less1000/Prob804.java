package comp.prep2019.less1000;
import java.util.*;
public class Prob804 {
	/**
	 * O(N) time and space
	 * @param words
	 * @return
	 */
	public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....",
        		"..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...",
        		"-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String w : words) {
        	StringBuilder sb = new StringBuilder();
        	for (char c : w.toCharArray()) {
        		sb.append(arr[c - 'a']);
        	}
        	set.add(sb.toString());
        }
        return set.size();
    }
}
