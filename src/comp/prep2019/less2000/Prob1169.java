package comp.prep2019.less2000;
import java.util.*;
public class Prob1169 {
	public List<String> invalidTransactions(String[] transactions) {
        Map<String, Map<String, Integer>[]> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        boolean[] invalid = new boolean[transactions.length];
        for (int j = 0; j < transactions.length; j++) {
        	String t = transactions[j];
        	String[] arr = t.split(",");
        	if (!map.containsKey(arr[0])) map.put(arr[0], new Map[1001]);
        	Map<String, Integer>[] cityMap = map.get(arr[0]);
        	int time = Integer.parseInt(arr[1]);
        	if (cityMap[time] == null) cityMap[time] = new HashMap<>();
        	for (int i = Math.max(0, time - 60); i <= Math.min(1000, time + 60); i++) {
        		if (cityMap[i] == null) continue;
        		for (Map.Entry<String, Integer> entry : cityMap[i].entrySet()) {
        			if (!entry.getKey().equals(arr[3])) {
        				invalid[j] = true;
        				invalid[entry.getValue()] = true;
        			}
        		}
        		if (!cityMap[time].containsKey(arr[3])) cityMap[time].put(arr[3], j);
        	}
        	if(Integer.parseInt(arr[2]) > 1000) invalid[j] = true;
        }
        for (int i = 0; i < invalid.length; i++) {
        	if (invalid[i]) result.add(transactions[i]);
        }
        return result;
    }
}
