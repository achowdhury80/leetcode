package com.prep2020.medium;
import java.util.*;
public class Problem1604 {
	/**
	 * O(nLogN)
	 * @param keyName
	 * @param keyTime
	 * @return
	 */
	public List<String> alertNames(String[] keyName, String[] keyTime) {
        Set<String> set = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
        	if (set.contains(keyName[i])) continue;
        	List<String> list = map.getOrDefault(keyName[i], new ArrayList<>());
        	list.add(keyTime[i]);
        	map.put(keyName[i], list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        	List<String> list = entry.getValue();
        	if (list.size() < 3) continue;
        	Collections.sort(list);
        	for (int i = 2; i < list.size(); i++) {
        		if (isWithInOneHr(list.get(i - 2), list.get(i))) {
        			set.add(entry.getKey());
        			break;
        		}
        	}
        }
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

	private boolean isWithInOneHr(String time1, String time2) {
		int t1 = timeInMinutes(time1), t2 = timeInMinutes(time2);
		return t2 - t1 <= 60;
	}
	
	private int timeInMinutes(String time) {
		String[] arr = time.split(":");
		int result = 0;
		if (arr[0].charAt(0) == '0') 
			result += (arr[0].charAt(1) - '0') * 60;
		else result += Integer.parseInt(arr[0]) * 60;
		if (arr[1].charAt(0) == '0')
			result += (arr[1].charAt(1) - '0');
		else result += Integer.parseInt(arr[1]);
		return result;
	}
}
