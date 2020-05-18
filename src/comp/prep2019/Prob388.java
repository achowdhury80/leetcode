package comp.prep2019;
import java.util.*;
public class Prob388 {
	public int lengthLongestPath(String input) {
        if (input.length() < 4) return 0;
        String[] arr = input.split("\n");
        Map<Integer, String> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
        	int level = arr[i].lastIndexOf("\t");
        	String name = arr[i].substring(level + 1);
        	String path = (level >- 1 ? map.get(level)  + "/" : "") + name;
        	if (name.indexOf(".") > -1) {
        		result = Math.max(result, path.length());
        	} else map.put(level + 1, path);
        }
        return result;
    }
}
