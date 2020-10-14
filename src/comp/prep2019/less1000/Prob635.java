package comp.prep2019.less1000;
import java.util.*;
public class Prob635 {
	private List<String[]> logs;
	private Map<String, Integer> indexMap;
	public Prob635() {
        logs = new ArrayList<>();
        indexMap = new HashMap<>();
        indexMap.put("Year", 4);
        indexMap.put("Month", 7);
        indexMap.put("Day", 10);
        indexMap.put("Hour", 13);
        indexMap.put("Minute", 16);
        indexMap.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        logs.add(new String[] {"" + id, timestamp});
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
    	List<Integer> list = new ArrayList<>();
    	int idx = indexMap.get(gra);
        for (String[] log : logs) {
        	String sub = log[1].substring(0, idx);
        	if (sub.compareTo(s.substring(0, idx)) >= 0 
        			&& sub.compareTo(e.substring(0, idx)) <= 0) 
        		list.add(Integer.parseInt(log[0]));
        }
        return list;
    }
}
