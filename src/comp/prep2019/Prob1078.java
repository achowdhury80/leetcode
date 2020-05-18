package comp.prep2019;
import java.util.*;
public class Prob1078 {
	public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] arr = text.trim().split(" ");
        for (int i = 2; i < arr.length; i++) {
        	if (first.equals(arr[i - 2]) && second.equals(arr[i - 1])) 
        		list.add(arr[i]);
        }
        return list.toArray(new String[0]);
    }
}
