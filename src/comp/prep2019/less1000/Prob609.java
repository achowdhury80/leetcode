package comp.prep2019.less1000;
import java.util.*;
public class Prob609 {
	public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
        	String[] arr = path.split(" ");
        	for (int i = 1; i < arr.length; i++) {
        		String fileName = arr[i].substring(0, arr[i].indexOf("("));
        		String content = arr[i].substring(arr[i].indexOf("(") + 1, 
        				arr[i].indexOf(")"));
        		List<String> list = map.getOrDefault(content, new ArrayList<>());
        		list.add(arr[0] + "/" + fileName);
        		map.put(content, list);
        	}
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        	if (entry.getValue().size() > 1) result.add(entry.getValue());
        }
        return result;
    }
}
