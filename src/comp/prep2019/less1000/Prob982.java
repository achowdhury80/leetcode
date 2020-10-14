package comp.prep2019.less1000;
import java.util.*;
public class Prob982 {
	public int countTriplets(int[] A) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int a : A) {
        	for (int b : A) {
        		countMap.put(a & b, countMap.getOrDefault(a & b, 0) + 1);
        	}
        }
        int result = 0;
        for (int a : A) {
        	for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
        		if ((a & entry.getKey()) == 0) result += entry.getValue();
        	}
        }
        return result;
    }
}
