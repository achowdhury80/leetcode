package comp.prep2019;
import java.util.*;
public class Prob401 {
	/**
	 * O(1)
	 * try all time combination
	 * @param num
	 * @return
	 */
	public List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
        	for (int j = 0; j < 60; j++) {
        		String s;
        		if (Integer.bitCount(i) + Integer.bitCount(j) == num) result.add(i + ":" + (s = ("00" + j)).substring(s.length() - 2));
        	}
        }
        return result;
    }
}
