package comp.prep2019.less1000;
import java.util.*;
public class Prob781 {
	public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ans : answers) {
        	map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	while(entry.getValue() > 0) {
	        	int population = entry.getKey() + 1;
	        	result += population;
	        	entry.setValue(entry.getValue() - population);
        	}
        	
        }
        return result;
    }
}
