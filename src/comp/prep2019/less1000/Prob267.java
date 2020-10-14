package comp.prep2019.less1000;
import java.util.*;
public class Prob267 {
	public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int odd = 0;
        for (char c : s.toCharArray()) {
        	int count;
        	map.put(c, (count = map.getOrDefault(c, 0) + 1));
        	if (count % 2 == 1) odd++;
        	else odd--;
        }
        List<String> result = new ArrayList<>();
        if (odd > 1) return result;
        String mid = "";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        	if (entry.getValue() % 2 == 1) {
        		mid += entry.getKey();
        		entry.setValue(entry.getValue() - 1);
        	}
        	for (int i = 0; i < entry.getValue() / 2; i++) {
        		sb.append(entry.getKey());
        	}
        }
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        List<StringBuilder> list = new ArrayList<>();
        permutate(list, arr, new boolean[arr.length], new StringBuilder());
        for (StringBuilder sbb : list) {
        	result.add(sbb.toString() + mid + sbb.reverse().toString());
        }
        return result;
        
    }
	
	private void permutate(List<StringBuilder> result, char[] arr, boolean[] used, StringBuilder sb) {
		if (sb.length() == used.length) {
			result.add(sb);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (used[i] || (i > 0 && arr[i - 1] == arr[i] && !used[i - 1])) continue;
			used[i] = true;
			sb.append(arr[i]);
			permutate(result, arr, used, new StringBuilder(sb));
			sb.deleteCharAt(sb.length() - 1);
			used[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Prob267 prob = new Prob267();
		System.out.println(prob.generatePalindromes("aabb"));
	}
}
