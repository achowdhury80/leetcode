package comp.prep2019.less1000;
import java.util.*;

public class Prob288 {
	private Map<String, Set<String>> map;
	public Prob288(String[] dictionary) {
        map = new HashMap<>();
        for (String w : dictionary) {
        	String abbv = findAbbv(w);
        	Set<String> set = map.getOrDefault(abbv, new HashSet<>());
        	set.add(w);
        	map.put(abbv, set);
        }
    }
    
	public boolean isUnique(String word) {
        String abbv = findAbbv(word);
        if (!map.containsKey(abbv) || map.get(abbv).contains(word) 
        		&& map.get(abbv).size() == 1) return true;
        return false;
    }
    
    private String findAbbv(String st) {
    	if (st.length() < 3) return st;
    	return "" + st.charAt(0) + (st.length() - 2) + st.charAt(st.length() - 1);
    }
    
    public static void main(String[] args) {
        Prob288 prob288 = null;
        prob288 = new Prob288(new String[]{"deer", "door", "cake", "card"});
        System.out.println(prob288.isUnique("dear"));
        System.out.println(prob288.isUnique("door"));
        System.out.println(prob288.isUnique("cart"));
        System.out.println(prob288.isUnique("cane"));
        System.out.println(prob288.isUnique("make"));
    }
}
