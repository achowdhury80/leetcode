package comp.prep2019;
import java.util.*;
public class Prob1487 {
	public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
        	String name = names[i];
        	if (map.containsKey(name)) {
        		int k = map.get(name);
        		k++;
        		while(map.containsKey(name + "(" + k + ")")) k++;
        		map.put(name, k);
        		name = name + "(" + k + ")";
        	} 
        	map.put(name, 0);
        	result[i] = name;
        }
        return result;
    }
}
