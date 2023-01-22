package com.prep2020.medium;
import java.util.*;
public class Problem609 {
	/**
	 * O(N)
	 * @param paths
	 * @return
	 */
	public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
        	String dir = path.substring(0, path.indexOf(' '));
        	String[] files = path.substring(path.indexOf(' ') + 1).split(" ");
        	for (String file : files) {
        		String fileName = file.substring(0, file.indexOf('('));
        		String content = file.substring(file.indexOf('(') + 1, file.length() - 1);
        		List<String> list = map.getOrDefault(content, new ArrayList<>());
        		list.add(dir + "/" + fileName);
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
