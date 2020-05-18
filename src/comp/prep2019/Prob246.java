package comp.prep2019;
import java.util.*;
public class Prob246 {
	
	public boolean isStrobogrammatic(String num) {
		if (num.length() < 1) return true;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);
        char[] arr = num.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
        	if (!map.containsKey(arr[i] - '0') 
        			|| !map.containsKey(arr[arr.length - i - 1] - '0') 
        			|| map.get(arr[i] - '0') != arr[arr.length - i - 1] - '0') 
        		return false;
        	
        }
        if (num.length() % 2 == 1) {
        	int mid = arr[num.length() / 2] - '0';
        	if (mid != 0 && mid != 1 && mid != 8) return false;
        }
        return true;
    }
}
