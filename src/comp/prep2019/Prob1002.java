package comp.prep2019;
import java.util.*;
public class Prob1002 {
	public List<String> commonChars(String[] A) {
        int[] arr = new int[26];
        for (char c : A[0].toCharArray()) arr[c - 'a']++;
        for (int i = 1; i < A.length; i++) {
        	char[] chars = A[i].toCharArray();
        	int[] temp = new int[26];
        	for (char c : chars) {
        		if (arr[c - 'a'] > 0) {
        			arr[c - 'a']--;
        			temp [c - 'a']++;
        		}
        	}
        	arr = temp;
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
        	while(arr[i] > 0) {
        		result.add("" + (char)(i + 'a'));
        		arr[i]--;
        	}
        }
        return result;
    }
}
