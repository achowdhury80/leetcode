package comp.prep2019.less2000;
import java.util.*;
public class Prob1396 {
	private Map<String, int[]> stationData;
	private Map<Integer, Pair> map;
	public Prob1396() {
		stationData = new HashMap<>();
		map = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        map.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair startPair = map.remove(id);
        String key;
        if (startPair.name.compareTo(stationName) > 0) {
        	key = stationName + "#" + startPair.name;
        } else key = startPair.name + "#" + stationName;
        int[] data = stationData.getOrDefault(key, new int[2]);
        data[0] += t - startPair.t;
        data[1]++;
        stationData.put(key, data);
    }
    
    public double getAverageTime(String startStation, String endStation) {
    	String key;
        if (startStation.compareTo(endStation) > 0) {
        	key = endStation + "#" + startStation;
        } else key = startStation + "#" + endStation;
        if (!stationData.containsKey(key)) return 0;
        int[] data = stationData.get(key);
        return (0.0 + data[0]) / data[1]; 
    }
    
    class Pair {
    	String name;
    	int t;
    	Pair(String name, int t) {
    		this.name = name;
    		this.t = t;
    	}
    }
}
