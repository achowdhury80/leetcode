package comp.prep2019.less1000;
import java.util.*;
public class Prob320 {
	public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        int n = word.length();
        char[] arr = word.toCharArray();
        for (int i = 0; i < Math.pow(2, n); i++) {
        	StringBuilder sb = new StringBuilder();
        	int count = 0;
        	for (int j = 0; j < n; j++) {
        		if (((i >> (n - 1 - j)) & 1) == 1) {
                    if(count > 0) sb.append(count);
        			count = 0;
        			sb.append(arr[j]);
        			
        		} else {
        			count++;
        		}
        	}
        	if (count > 0) sb.append(count);
        	result.add(sb.toString());
        }
        return result;
    }
}
