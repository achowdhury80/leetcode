package comp.prep2019;
import java.util.*;
public class Prob1366 {
	public String rankTeams(String[] votes) {
        int n = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();
        for (String vote : votes) {
        	char[] arr = vote.toCharArray();
        	for (int i = 0; i < arr.length; i++) {
        		if (!map.containsKey(arr[i])) map.put(arr[i], new int[n]);
        		int[] pos = map.get(arr[i]);
        		pos[i]++;
        	}
        }
        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (x, y) -> compare(x, y));
        String result = "";
        for (Map.Entry<Character, int[]> entry : list) result += entry.getKey();
        return result;
    }
	
	private int compare(Map.Entry<Character, int[]> x, Map.Entry<Character, int[]> y) {
		int[] a = x.getValue(), b = y.getValue();
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) return b[i] - a[i];
		}
		return x.getKey().compareTo(y.getKey());
	}
}
