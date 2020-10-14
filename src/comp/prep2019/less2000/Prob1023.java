package comp.prep2019.less2000;
import java.util.*;
public class Prob1023 {
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		char[] p = pattern.toCharArray();
		for (String q : queries) {
			char[] arr = q.toCharArray();
			int j = 0;
			boolean matched = true;
			for (int i = 0; i < arr.length; i++) {
				if (j == p.length) {
					if (arr[i] < 'a') {
						matched = false;
						break;
					}
					continue;
				}
				if (arr[i] == p[j]) {
					j++;
					continue;
				}
				if (arr[i] < 'a') {
					matched = false;
					break;
				}
				
			}
			if (j != p.length) matched = false;
			result.add(matched);
			
		}
		return result;
    }
}
