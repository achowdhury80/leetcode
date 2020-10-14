package comp.prep2019.less1000;
import java.util.*;
public class Prob422 {
	public boolean validWordSquare(List<String> words) {
		int m = words.size();
        for (int i = 0; i < m; i++) {
        	String w1 = words.get(i);
        	for (int j = 0; j < w1.length(); j++) {
        		String otherWord = null;
                if (words.size() <= j || (otherWord = words.get(j)).length() <= i) return false;
                if (w1.charAt(j) != otherWord.charAt(i)) return false;
        	}
        }
        return true;
    }
}
