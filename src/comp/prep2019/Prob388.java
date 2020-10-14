package comp.prep2019;
import java.util.*;
public class Prob388 {
	public int lengthLongestPath(String input) {
        String[] arr = input.split("\\n");
        int result = 0;
        Map<Integer, String> map = new HashMap<>();
        map.put(-2, "");
        for (int i = 0; i < arr.length; i++) {
        	int lastTabIndex = arr[i].lastIndexOf('\t');
        	if (arr[i].indexOf(".") > -1) {
        		String path = map.get(lastTabIndex - 1) + arr[i].substring(lastTabIndex + 1);
        		result = Math.max(result, path.length());
        	} else {
        		map.put(lastTabIndex, map.get(lastTabIndex - 1) 
        				+ arr[i].substring(lastTabIndex + 1) + "/");
        	}
        	
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob388 prob = new Prob388();
		System.out.println(prob.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
	}
}
